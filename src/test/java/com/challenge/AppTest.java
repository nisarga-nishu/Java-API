package com.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


class AppTest {

    TotalCars tc;
    ArrayList<String> al = new ArrayList<String>();
    TopThreeCars ttc ;
    LeastCars lc;

    @BeforeEach
    public void initiateAll() throws FileNotFoundException{
        
        tc = new TotalCars();
        ttc = new TopThreeCars();
        lc = new LeastCars();

        File file = new File("N:\\CodeChallenge\\seek\\src\\main\\java\\com\\challenge\\InputFile.txt");
        Scanner sc  = new Scanner(file);
        while(sc.hasNextLine())
        {
            al.add(sc.nextLine());
        }
        sc.close();
    }

    @Test
    public void shouldGetTotalCarsnFormatDate()  {

        /** Total cars test case **/
        Assertions.assertNotNull(tc.getTotalCars(al));
        int testVal = 398;          // test value
        Assertions.assertEquals(testVal,tc.getTotalsum()); //compare the values

        /** Formatted date test case **/
        String[][] testArray = {{"2016-12-01", "5"}, {"2016-12-01", "12"}, {"2016-12-01", "14"}, {"2016-12-01", "15"}, {"2016-12-01", "25"}, {"2016-12-01", "46"}, {"2016-12-01", "42"}, {"2016-12-01", "9"}, {"2016-12-01", "11"}, {"2016-12-01", "0"}, {"2016-12-05", "18"}, {"2016-12-05", "15"}, {"2016-12-05", "7"}, {"2016-12-05", "6"}, {"2016-12-05", "9"}, {"2016-12-05", "11"}, {"2016-12-05", "15"}, {"2016-12-08", "33"}, {"2016-12-08", "28"}, {"2016-12-08", "25"}, {"2016-12-08", "21"}, {"2016-12-08", "16"}, {"2016-12-08", "11"}, {"2016-12-09", "4"}};
        Assertions.assertNotNull(tc.getFormattedDate());
        Assertions.assertEquals(Arrays.deepToString(testArray),Arrays.deepToString(tc.getFormattedDate()));    //compare the values  
    }

    @Test
    public void shouldGetTopThreeCars() {

        /** Top three cars test case **/
        tc.getTotalCars(al);
        Map<String,Integer> testArray = new HashMap<String,Integer>(); // test value
        testArray.put("2016-12-08T18:00:00",33);
        testArray.put("2016-12-01T08:00:00",42);
        testArray.put("2016-12-01T07:30:00",46);

        ttc.getTopThreeCars(tc.getUnFormattedDate());
        Assertions.assertEquals(testArray,ttc.getVal()); //compare the value
    }

    @Test
    public void shouldGetLeastCars()  {

        /** Least car count test case **/
        tc.getTotalCars(al);
        ttc.getTopThreeCars(tc.getUnFormattedDate());
        lc.getLeastCars(ttc.getSortVal());

        int testVal = 31; //test value 
        Assertions.assertEquals(testVal,lc.getLeastVal()); //compare the least value

        List<String> testList = new ArrayList<String>(); // test value
        testList.add("2016-00-01T06:00:00");
        testList.add("2016-30-01T05:30:00");
        testList.add("2016-00-01T05:00:00");
        Assertions.assertEquals(testList,lc.getThreeDates()); // compare the 1.5 hours date
    }
    }

