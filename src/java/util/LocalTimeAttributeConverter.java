/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;
/**
 *
 * @author demetrius
 */
@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime entityAttribute) {
        if (entityAttribute == null) {
            return null;
        }

        return Time.valueOf(entityAttribute);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time databaseColumn) {
        if (databaseColumn == null) {
            return null;
        }

        return databaseColumn.toLocalTime();
    }

}
