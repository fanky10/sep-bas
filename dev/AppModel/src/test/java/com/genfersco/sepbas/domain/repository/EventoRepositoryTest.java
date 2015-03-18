package com.genfersco.sepbas.domain.repository;

import com.genfersco.sepbas.domain.mocked.CuartoMocked;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.genfersco.sepbas.domain.mocked.EventoMocked;
import com.genfersco.sepbas.domain.model.Cuarto;
import com.genfersco.sepbas.domain.model.Evento;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dataAccessContext.xml"})
@Transactional
public class EventoRepositoryTest {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private EventoMocked eventoMocked;
    @Autowired
    private CuartoMocked cuartoMocked;

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
    public void testGuardarEventoHijo() {
        // evento hijo
        Evento eventoHijo = eventoMocked.getEvento(evento);
        assertTrue(eventoHijo != null
                && eventoRepository.exists(eventoHijo.getId()));
    }
    
    @Test
    public void testFindByCuarto() {
        Cuarto c = cuartoMocked.getCuarto();
        List<Evento> eventosGenerados = new ArrayList<Evento>();
        for(int i = 0;i < 5;i++){
            eventosGenerados.add(eventoMocked.getEvento(c, null));
        }
        List<Evento> found = eventoRepository.findByCuarto(c);
        assertTrue(!found.isEmpty());
    }

}
