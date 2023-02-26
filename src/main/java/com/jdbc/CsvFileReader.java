package com.jdbc;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvFileReader {
    public static void main(String[] args) throws IOException, CsvException {
        FileReader filereader = new FileReader("C:\\Users\\User\\Desktop\\fileReader.csv");
        // create csvReader object and skip first Line
        CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
        List<String[]> allData = csvReader.readAll();

        // print Data
        for (String[] row : allData) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

    }
}
