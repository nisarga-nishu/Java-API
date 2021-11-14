package com.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeastCarsTest {
    @Test
    public void shouldGetLeastCars() throws FileNotFoundException {

        File file = new File("N:\\CodeChallenge\\seek\\src\\main\\java\\com\\challenge\\InputFile.txt");
        Scanner sc  = new Scanner(file);
        ArrayList<String> al = new ArrayList<String>();

        while(sc.hasNextLine())
        {
            al.add(sc.nextLine());
        }
        TotalCars tc = new TotalCars();
        TopThreeCars ttc = new TopThreeCars();
        LeastCars lc = new LeastCars();
        tc.getTotalCars(al);
        ttc.getTopThreeCars(tc.getUnFormattedDate());
        lc.getLeastCars(ttc.getSortVal());

        int testVal = 31;
        Assertions.assertEquals(testVal,lc.getLeastVal());

        List<String> testList = new ArrayList<String>();
        testList.add("2016-00-01T06:00:00");
        testList.add("2016-30-01T05:30:00");
        testList.add("2016-00-01T05:00:00");
        Assertions.assertEquals(testList,lc.getThreeDates());
        sc.close();

    }


    
}
