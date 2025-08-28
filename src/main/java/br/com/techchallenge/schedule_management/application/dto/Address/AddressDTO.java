package br.com.techchallenge.schedule_management.application.dto.Address;

import br.com.techchallenge.schedule_management.application.domain.entity.AddressDomain;
import br.com.techchallenge.schedule_management.infrastructure.address.entity.Address;

public record AddressDTO(

        String zipCode,
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state

) {

    public AddressDTO (AddressDomain addressDomain) {
        this(
                addressDomain.getZipCode(),
                addressDomain.getStreet(),
                addressDomain.getNumber(),
                addressDomain.getComplement(),
                addressDomain.getNeighborhood(),
                addressDomain.getCity(),
                addressDomain.getState()
        );
    }

    public AddressDTO (Address address) {
        this(
                address.getZipCode(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState()
        );
    }

}
