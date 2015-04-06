/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.app.services.impl;

import com.genfersco.sepbas.app.services.EventoManager;
import com.genfersco.sepbas.domain.mocked.CuartoMocked;
import com.genfersco.sepbas.domain.mocked.EventoMocked;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.EstadoEvento;
import com.genfersco.sepbas.domain.model.Evento;
import com.genfersco.sepbas.domain.repository.EventoRepository;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fanky
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dataAccessContext.xml"})
@Transactional
public class EventoManagerTest {

    @Autowired
    private CuartoMocked cuartoMocked;
    @Autowired
    private EventoMocked eventoMocked;
    @Autowired
    private EventoManager eventoManager;
    @Autowired
    private EventoRepository eventoRepository;

    private Evento evento = new Evento();

    @Before
    public void buildData() {
        evento = eventoMocked.getEvento(cuartoMocked.getCuarto(), null);
    }

    @Test
    public void testGuardarEvento() {
        assertTrue(eventoRepository.count() > 0);
        assertTrue(eventoRepository.exists(evento.getId()));
    }

    @Test
    public void testEliminarEvento() {
        int eventoId = evento.getId();
        boolean deleted = eventoManager.deleteEvento(eventoId);
        Evento modificado = eventoRepository.findOne(eventoId);
        assertTrue(deleted && modificado.getEstado().equals(EstadoEvento.ELIMINADO));
    }

    @Test
    public void testFindByCuartoWithDeletedEvent() {
        int eventCount = 5;
        Cuarto c = cuartoMocked.getCuarto();
        List<Evento> eventosGenerados = new ArrayList<Evento>();
        for (int i = 0; i < eventCount; i++) {
            eventosGenerados.add(eventoMocked.getEvento(c, null));
        }
        List<Evento> foundByCuartoOriginal = eventoRepository.findByCuarto(c);
        assertTrue(!foundByCuartoOriginal.isEmpty() && eventosGenerados.size() == foundByCuartoOriginal.size());
        
        // now we delete one event and check the events found length
        Evento toBeDeleted = foundByCuartoOriginal.get(0);
        eventoManager.deleteEvento(toBeDeleted.getId());
        
        List<Evento> foundByCuartoModified = eventoRepository.findByCuarto(c);
        boolean isEventFound = false;
        for(Evento e: foundByCuartoModified) {
            if(e.getId().equals(toBeDeleted.getId())) {
                isEventFound = true;
            }
        }
        assertTrue(!isEventFound);
        assertTrue(foundByCuartoModified.size() < foundByCuartoOriginal.size());
    }

}
