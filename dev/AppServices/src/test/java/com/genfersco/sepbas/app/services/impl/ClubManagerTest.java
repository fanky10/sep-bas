/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.app.services.impl;


import static org.junit.Assert.assertTrue;

import com.genfersco.sepbas.app.services.ClubManager;
import com.genfersco.sepbas.domain.mocked.ClubMocked;
import com.genfersco.sepbas.domain.model.Club;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Owner
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dataAccessContext.xml"})
@Transactional
public class ClubManagerTest {

    @Autowired
    private ClubMocked clubMocked;
    @Autowired
    private ClubManager clubManager;
    private Club club = new Club();

    @Before
    public void buildData() {
        club = clubMocked.getClub("SportClub", "Caniada", false);
        club = clubManager.addClub(club);
    }

    @Test
    public void testGetAll() {
        List<Club> clubes = clubManager.getClubes();
        assertTrue(clubes != null && !clubes.isEmpty());
    }
}
