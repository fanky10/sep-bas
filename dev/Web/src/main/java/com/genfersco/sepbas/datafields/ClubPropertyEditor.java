package com.genfersco.sepbas.datafields;

import java.beans.PropertyEditorSupport;

import com.genfersco.sepbas.app.services.ServicesManager;

public class ClubPropertyEditor extends PropertyEditorSupport {

	private ServicesManager servicesManager;

	public ClubPropertyEditor(ServicesManager servicesManager) {
		this.servicesManager = servicesManager;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		super.setValue(getServicesManager().getClub(text));
	}

	public void setServicesManager(ServicesManager servicesManager) {
		this.servicesManager = servicesManager;
	}

	public ServicesManager getServicesManager() {
		return servicesManager;
	}

}
