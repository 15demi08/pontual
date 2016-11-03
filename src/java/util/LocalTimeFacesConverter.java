/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author demetrius
 */
@FacesConverter("localTimeFacesConverter")
public class LocalTimeFacesConverter implements Converter {

    LocalTime localTime;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String stringValue) {

        if (null == stringValue || stringValue.isEmpty()) {
            return null;
        }

        try {
            localTime = LocalTime.parse(stringValue);
        } catch (DateTimeParseException e) {
            throw new ConverterException("Erro de conversão: " + e.getMessage());
        }

        return localTime;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object localTimeValue) {

        if (null == localTimeValue) {
            return "";
        }

        return ((LocalTime) localTimeValue).format(DateTimeFormatter.ofPattern("kk:mm:ss"));
    }

}
