package com.challenge;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TotalCars {
    
    public int totalsum ;
    public String[][] formattedDate;
    public String[][] unFormattedDate;

    public int getTotalsum()
    {    
        return totalsum;
    }
    public void setTotalsum(int totalsum)
    {
        this.totalsum = totalsum;
    }
    public String[][] getFormattedDate()
    { 
        return formattedDate;
    }
    public void setFormattedDate(String[][] formattedDate)
    {
        this.formattedDate = formattedDate;
    }
    public String[][] getUnFormattedDate()
    { 
        return unFormattedDate;
    }
    public void setUnFormattedDate(String[][] unFormattedDate)
    {
        this.unFormattedDate = unFormattedDate;
    }
    public String[][] getTotalCars(ArrayList<String> al)
    {
        String str[] = new String[al.size()]; 
        al.toArray(str);    // converting arraylist to String array 
        
        String str1[][] = new String[al.size()][2];     //Size is 2 here, since we need two columns displaying date and car counts.

        String parts[] = new String[al.size()]; //partiontion Array

        for(int i=0; i < str.length; i++) {

            parts = str[i].split("\\s+");  // splitting the String after space to get the car counts and add to a seperate array
            for(int j = 0; j < parts.length || j < 2; j++) {
            str1[i][j] = parts[j]; //Adding the separated String array to 2D array after partitioning

        }
        }
        int sum =0;
       for(int i=0;i<str1.length;i++)
       {
           for(int j=1;j< 2;j++)
           {
            sum = sum + Integer.parseInt(str1[i][j]); //getting the overall car counts from 2nd column
           }
       }
       System.out.println("The number of cars seen in total: "+ sum); // first output
       setTotalsum(sum); // storing the value in setter to access it later in unit test
       System.out.println();

       /* Copying the array to new array to get the formatted date */
      String [][] str2 = new String[str1.length][]; 
      for(int i = 0; i < str1.length; i++)
      {
        str2[i] = new String[str1[i].length];
      for(int j=0; j<str1[i].length; j++)
      {
          str2[i][j]=str1[i][j];
      }
    }

      // to get the Formatted Date

      for( int i=0;i<str2.length;i++)
      {
          for(int j=0;j<1;j++)
          {
          try {
           Date date = new SimpleDateFormat("yyyy-mm-dd").parse(str2[i][j]);  //parsing the string to required date format
           DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
           str2[i][j]= df.format(date);  // once the format is changed, changing back the date type to String
              } catch (ParseException e) {
           e.printStackTrace();
              }
          }
      }

       System.out.println("Formatted Date: "); // Formatted date with the sum of cars ,Second output
       System.out.println();

      for (String[] x : str2)
      {
          for( String y: x)
          {
         System.out.print(" "+y);
          }
         System.out.println();
      }
      System.out.println();

     setFormattedDate(str2); //storing the values using setters for later use
     setUnFormattedDate(str1);
    
     return str1; // returning the unformatted date to solve the next question
       
    }
   
    
}
