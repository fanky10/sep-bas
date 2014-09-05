package com.genfersco.sepbas.domain.mocked;

import com.genfersco.sepbas.domain.model.Club;
import com.genfersco.sepbas.domain.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClubMocked {
    @Autowired
    private ClubRepository clubRepository;
	public Club getClub() {
		Club club = new Club();
		club.setNombre("SportClub");
		club.setLocalidad("Canada de Gomez");
                club = clubRepository.save(club);
		return club;
	}
}
