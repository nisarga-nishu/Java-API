package com.challenge;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public  class App {


    public static void main(String[] args) throws FileNotFoundException {

        String userHome = System.getProperty("user.dir");
        File file = new File(userHome+"\\src\\main\\java\\com\\challenge\\InputFile.txt"); //fetch input file from current working directory

        Scanner sc  = new Scanner(file);
        ArrayList<String> al = new ArrayList<String>(); // Using Arralylist, as the index accessing is faster
        
        while(sc.hasNextLine())
        {
            al.add(sc.nextLine()); //accessing each line from text file and storing it in arraylist
        }

        /** Initializing dependable Classes */

        TotalCars tc = new TotalCars();
        TopThreeCars ttc = new TopThreeCars();
        LeastCars lc = new LeastCars();

        lc.getLeastCars(ttc.getTopThreeCars(tc.getTotalCars(al)));

        sc.close();
    }

    }
  





