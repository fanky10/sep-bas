/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genfersco.sepbas.datafields;

import com.genfersco.sepbas.app.services.ServicesManager;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author fanky
 */
public class ArbitroPropertyEditor extends PropertyEditorSupport {

    private ServicesManager servicesManager;

    public ArbitroPropertyEditor(ServicesManager servicesManager) {
        this.servicesManager = servicesManager;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        super.setValue(getServicesManager().getArbitro(Integer.parseInt(text)));
    }

    public void setServicesManager(ServicesManager servicesManager) {
        this.servicesManager = servicesManager;
    }

    public ServicesManager getServicesManager() {
        return servicesManager;
    }

}
