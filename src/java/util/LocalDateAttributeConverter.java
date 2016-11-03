/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
/**
 *
 * @author demetrius
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate entityAttribute) {
        if (entityAttribute == null) {
            return null;
        }

        return Date.valueOf(entityAttribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date databaseColumn) {
        if (databaseColumn == null) {
            return null;
        }

        return databaseColumn.toLocalDate();
    }

}
