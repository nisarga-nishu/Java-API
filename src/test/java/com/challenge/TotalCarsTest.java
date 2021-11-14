package com.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TotalCarsTest {
    @Test
    public void shouldGetTotalCars() throws FileNotFoundException {

        File file = new File("N:\\CodeChallenge\\seek\\src\\main\\java\\com\\challenge\\InputFile.txt");
        Scanner sc  = new Scanner(file);
        ArrayList<String> al = new ArrayList<String>();

        while(sc.hasNextLine())
        {
            al.add(sc.nextLine());
        }
        TotalCars tc = new TotalCars();

        //Total cars test case
        Assertions.assertNotNull(tc.getTotalCars(al));
        Assertions.assertEquals(398,tc.getTotalsum());
        Assertions.assertNotNull(tc.getTotalsum());

        //Formatted date test case
        String[][] testArray = {{"2016-12-01", "5"}, {"2016-12-01", "12"}, {"2016-12-01", "14"}, {"2016-12-01", "15"}, {"2016-12-01", "25"}, {"2016-12-01", "46"}, {"2016-12-01", "42"}, {"2016-12-01", "9"}, {"2016-12-01", "11"}, {"2016-12-01", "0"}, {"2016-12-05", "18"}, {"2016-12-05", "15"}, {"2016-12-05", "7"}, {"2016-12-05", "6"}, {"2016-12-05", "9"}, {"2016-12-05", "11"}, {"2016-12-05", "15"}, {"2016-12-08", "33"}, {"2016-12-08", "28"}, {"2016-12-08", "25"}, {"2016-12-08", "21"}, {"2016-12-08", "16"}, {"2016-12-08", "11"}, {"2016-12-09", "4"}};
        Assertions.assertNotNull(tc.getFormattedDate());
        Assertions.assertEquals(Arrays.deepToString(testArray),Arrays.deepToString(tc.getFormattedDate()));

        sc.close();
       

    }
}
