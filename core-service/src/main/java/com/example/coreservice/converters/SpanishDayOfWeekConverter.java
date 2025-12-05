package com.example.coreservice.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.DayOfWeek;

@Converter(autoApply = true)
public class SpanishDayOfWeekConverter implements AttributeConverter<DayOfWeek,String> {
    private static final java.util.Map<String, DayOfWeek> SPANISH_TO_JAVA =
            java.util.Map.of(
                    "Lunes", DayOfWeek.MONDAY,
                    "Martes", DayOfWeek.TUESDAY,
                    "Miercoles", DayOfWeek.WEDNESDAY,
                    "Jueves", DayOfWeek.THURSDAY,
                    "Viernes", DayOfWeek.FRIDAY,
                    "Sabado", DayOfWeek.SATURDAY,
                    "Domingo", DayOfWeek.SUNDAY
            );
    private static final java.util.Map<DayOfWeek, String> JAVA_TO_SPANISH =
            java.util.Map.of(
                    DayOfWeek.MONDAY, "Lunes",
                    DayOfWeek.TUESDAY, "Martes",
                    DayOfWeek.WEDNESDAY, "Miercoles",
                    DayOfWeek.THURSDAY, "Jueves",
                    DayOfWeek.FRIDAY, "Viernes",
                    DayOfWeek.SATURDAY, "Sabado",
                    DayOfWeek.SUNDAY, "Domingo"
            );
    @Override
    public String convertToDatabaseColumn(DayOfWeek attribute) {
        if (attribute == null) {
            return null;
        }
        // Traduce DayOfWeek.MONDAY a 'Lunes'
        return JAVA_TO_SPANISH.get(attribute);
    }

    @Override
    public DayOfWeek convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        // Traduce 'Lunes' a DayOfWeek.MONDAY
        return SPANISH_TO_JAVA.get(dbData);
    }
}
