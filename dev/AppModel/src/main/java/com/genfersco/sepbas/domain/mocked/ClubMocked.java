package com.genfersco.sepbas.domain.mocked;

import com.genfersco.sepbas.domain.model.Club;

public class ClubMocked {

	public static Club getClub() {
		Club club = new Club();
		club.setNombre("SportClub");
		club.setLocalidad("Canada de Gomez");
		return club;
	}
}
