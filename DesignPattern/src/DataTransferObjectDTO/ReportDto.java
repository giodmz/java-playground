package DataTransferObjectDTO;

/*
* Padrão arquitetural de aplicações corporativas
* Ele manda uma determinada quantidade de dados
* de diferentes entidades para uma API.
* Basicamente será criada uma classe com os atributos
* desejados  */

import Factory.Country;
import Factory.Currency;

public class ReportDto {
    private String aircraftName;
    private String personName;
    private Country country;
    private Currency currency;


    public static final class ReportDtoBuilder {
        private String aircraftName;
        private String personName;
        private Country country;
        private Currency currency;

        private ReportDtoBuilder() {
        }

        public static ReportDtoBuilder builder() {
            return new ReportDtoBuilder();
        }

        public ReportDtoBuilder aircraftName(String aircraftName) {
            this.aircraftName = aircraftName;
            return this;
        }

        public ReportDtoBuilder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public ReportDtoBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public ReportDtoBuilder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ReportDto build() {
            ReportDto reportDto = new ReportDto();
            reportDto.personName = this.personName;
            reportDto.country = this.country;
            reportDto.currency = this.currency;
            reportDto.aircraftName = this.aircraftName;
            return reportDto;
        }
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "aircraftName='" + aircraftName + '\'' +
                ", personName='" + personName + '\'' +
                ", country=" + country +
                ", currency=" + currency +
                '}';
    }
}


