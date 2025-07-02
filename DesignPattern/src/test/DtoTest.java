package test;

import Builder.Person;
import DataTransferObjectDTO.ReportDto;
import Factory.Country;
import Factory.Currency;
import Factory.CurrencyFactory;
import Singleton.Aircraft;

public class DtoTest {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("777");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Person person = Person.PersonBuilder
                .builder()
                .firstName("Marcelo")
                .lastName("Foda")
                .build();
        ReportDto reportDto = ReportDto.ReportDtoBuilder.builder()
                .aircraftName(aircraft.getName())
                .country(country)
                .currency(currency)
                .personName(person.getFirstName())
                .build();

        System.out.println(reportDto);
    }
}
