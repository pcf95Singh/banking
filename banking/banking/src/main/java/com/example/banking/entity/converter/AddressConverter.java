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

        return address.getAddressLine1()
                + DELIMITER + address.getAddressLine2()
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

        String addressLine1 = pieces[0];
        String addressLine2 = pieces[1];
        String city = pieces[2];
        String state = pieces[3];
        long pin = Long.parseLong(pieces[4]);
        String country = pieces[5];

        return new Address(addressLine1,addressLine2, city, state, pin, country);
    }
}