package com.jdbc;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileWriter {
    public static void main(String[] args) throws IOException {
        FileWriter outPutFile = new FileWriter("C:\\Users\\User\\Desktop\\FileWritter.csv");
        // create CSVWriter object fileWriter object as parameter
        CSVWriter writer = new CSVWriter(outPutFile);
        // create a List which contains String array
        List<String[]> data = new ArrayList<String[]>();
        data.add(new String[] { "Name", "Class", "Marks" });
        data.add(new String[] { "Aman", "10", "620" });
        data.add(new String[] { "Suraj", "10", "630" });
        writer.writeAll(data);

     // closing writer connection
        writer.close();
    }
    }

