package com.genfersco.sepbas.datafields;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.genfersco.sepbas.web.constants.WebAppConstants;

public class FechaPropertyEditor extends PropertyEditorSupport {

    public FechaPropertyEditor() {
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Date dateValue = null;
        try {
            dateValue = new SimpleDateFormat(WebAppConstants.FORMATO_FECHA)
                    .parse(text);
        } catch (ParseException ex) {

        }
        super.setValue(dateValue);
    }
}
