package com.genfersco.sepbas.app.services;

import java.util.List;

import com.genfersco.sepbas.domain.model.Club;

public interface ClubManager {
	public List<Club> getClubes();

	public Club addClub(Club club);
	
	public void deleteClub(Integer id);
	
	public Club getClub(Integer id);
}
