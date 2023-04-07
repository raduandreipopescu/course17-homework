package service;

import model.Country;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CountryService {
    private List<Country> countries;

    public CountryService() throws IOException {
        CountryReader countryReader = new CountryReader("src/main/resources/countries.txt");
        this.countries = countryReader.readCountries();
    }

    public List<Country> listAllCountries() {
        return countries;
    }

    public List<String> listAllCountryNames() {
        return countries.stream()
                .map(Country::getName)
                .toList();
    }

    public String getCapitalOfCountry(String requestedCountry) {
        Optional<String> result = countries.stream()
                .filter(country -> country.getName().equals(requestedCountry))
                .map(Country::getCapital)
                .findFirst();
        return result.orElse(null);
    }

    public long getPopulationOfCountry(String requestedCountry) {
        Optional<Long> result = countries.stream()
                .filter(country -> country.getName().equals(requestedCountry))
                .map(Country::getPopulation)
                .findFirst();
        if (result.isPresent()) {
            return result.get();
        }
        return -1;
    }

    public List<Country> getCountriesInContinent(String requestedContinent) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(requestedContinent))
                .toList();
    }

    public List<String> getCountryNeighbours(String requestedCountry) {
        Optional<List<String>> result = countries.stream()
                .filter(country -> country.getName().equals(requestedCountry))
                .map(Country::getNeighbours)
                .findFirst();
        return result.orElse(null);
    }

    public List<Country> getCountriesInContinentWithPopulationLargerThan(String requestedContinent, Long populationLimit) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(requestedContinent))
                .filter(country -> country.getPopulation() > populationLimit)
                .toList();
    }

    public List<Country> getCountriesWithFilteredNeighbours(String requestedNeighbour, String excludedNeighbour) {
        return countries.stream()
                .filter(country -> country.getNeighbours().contains(requestedNeighbour))
                .filter(country -> !country.getNeighbours().contains(excludedNeighbour))
                .toList();
    }
}
