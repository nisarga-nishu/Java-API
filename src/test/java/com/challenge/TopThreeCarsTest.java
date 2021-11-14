package com.challenge;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopThreeCarsTest {
    @Test
    public void shouldGetTopThreeCars() throws FileNotFoundException {

        File file = new File("N:\\CodeChallenge\\seek\\src\\main\\java\\com\\challenge\\InputFile.txt");
        Scanner sc  = new Scanner(file);
        ArrayList<String> al = new ArrayList<String>();

        while(sc.hasNextLine())
        {
            al.add(sc.nextLine());
        }
        TotalCars tc = new TotalCars();
        
        TopThreeCars ttc = new TopThreeCars();
        tc.getTotalCars(al);

        Map<String,Integer> testArray = new HashMap<String,Integer>();
        testArray.put("2016-12-08T18:00:00",33);
        testArray.put("2016-12-01T08:00:00",42);
        testArray.put("2016-12-01T07:30:00",46);

        ttc.getTopThreeCars(tc.getUnFormattedDate());
        Assertions.assertEquals(testArray,ttc.getVal());
        sc.close();


    }
}
