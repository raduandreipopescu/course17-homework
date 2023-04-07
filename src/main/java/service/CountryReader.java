package service;

import model.Country;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class CountryReader {
    private final String filePath;

    public CountryReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Country> readCountries() throws IOException {
        List<Country> countries = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath));
        String readLine;

        while ((readLine = bufferedReader.readLine()) != null) {
            countries.add(getSplitReadLine(readLine));
        }

        bufferedReader.close();
        return countries;
    }

    private static Country getSplitReadLine(String readLine) {
        String[] partOfReadLine = readLine.split(Pattern.quote("|"));
        String uniqueID = UUID.randomUUID().toString();
        List<String> neighbours = new ArrayList<>();
        if (partOfReadLine.length > 5) {
            neighbours.addAll(Arrays.asList(partOfReadLine[5].split("~")));
        }

        Country country = Country.builder()
                .id(uniqueID)
                .name(partOfReadLine[0])
                .capital(partOfReadLine[1])
                .population(Long.valueOf(partOfReadLine[2]))
                .area(Integer.valueOf(partOfReadLine[3]))
                .continent(partOfReadLine[4])
                .neighbours(neighbours)
                .build();
        return country;
    }
}
