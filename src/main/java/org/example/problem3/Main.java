package org.example.problem3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = "newcities.txt";
        ClassLoader classLoader = Main.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        List<City> allCities = FileUtils.readLines(file, StandardCharsets.UTF_8)
                .stream()
                .skip(1)
                .map(line -> City.of(line.split(",")[0], new Date(Long.parseLong(line.split(",")[2])), line.split(",")[1]))
                .toList();
    }

}
