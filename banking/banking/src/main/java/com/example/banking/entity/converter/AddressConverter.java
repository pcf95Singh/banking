package com.example.banking.entity.converter;

import com.example.banking.entity.Address;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AddressConverter implements AttributeConverter<Address, String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(Address address) {

        if (address == null) {
            return null;
        }

        return address.getStreet()
                + DELIMITER + address.getCity()
                + DELIMITER + address.getState()
                + DELIMITER + address.getPinCode()
                + DELIMITER + address.getCountry();
    }

    @Override
    public Address convertToEntityAttribute(String dbData) {

        if (dbData == null || dbData.isEmpty()) {
            return null;
        }

        String[] pieces = dbData.split(DELIMITER, -1);

        String street = pieces[0];
        String city = pieces[1];
        String state = pieces[2];
        long pin = Long.parseLong(pieces[3]);
        String country = pieces[4];

        return new Address(street, city, state, pin, country);
    }
}