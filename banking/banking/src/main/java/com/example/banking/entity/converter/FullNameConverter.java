package com.example.banking.entity.converter;

import com.example.banking.entity.FullName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class FullNameConverter implements AttributeConverter<FullName, String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(FullName fullName) {
        if (fullName == null){
            return null;
        }
        String middleName = (fullName.getMiddleName() == null) ? "" : fullName.getMiddleName();
        return fullName.getFirstName()
                + DELIMITER + fullName.getMiddleName()
                + DELIMITER + fullName.getLastName();
    }

    @Override
    public FullName convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()){
            return null;
        }
        String[] pieces = dbData.split(DELIMITER, -1);
        String firstName = pieces[0];
        String middleName = pieces[1];
        String lastName = pieces[2];
        return new FullName(firstName, middleName, lastName);
    }
}
