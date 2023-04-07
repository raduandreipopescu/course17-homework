import service.CountryService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            CountryService countryService = new CountryService();
            System.out.println("All countries: " + countryService.listAllCountries());
            System.out.println();
            System.out.println("All country names: " + countryService.listAllCountryNames());
            System.out.println();
            System.out.println("Capital of Andorra is: " + countryService.getCapitalOfCountry("Andorra"));
            System.out.println();
            System.out.println("Population of Croatia is: " + countryService.getPopulationOfCountry("Croatia"));
            System.out.println();
            System.out.println("Countries in Oceania: " + countryService.getCountriesInContinent("Oceania"));
            System.out.println();
            System.out.println("Neighbours of France are: " + countryService.getCountryNeighbours("France"));
            System.out.println();
            System.out.println("Countries in Europe with population over 50 millions are: " + countryService.getCountriesInContinentWithPopulationLargerThan("Europe", 50000000L));
            System.out.println();
            System.out.println("Countries neighbour with Italy, but not with Germany: " + countryService.getCountriesWithFilteredNeighbours("ITA", "DEU"));

        } catch (IOException e) {
            System.out.println("Caught an exception! " + e.getMessage());
        }
    }
}
