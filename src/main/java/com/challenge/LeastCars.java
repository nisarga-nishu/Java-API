package com.challenge;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.*;

public class LeastCars {

    public int leastVal;
    public String k1;
    public String k2;
    public String k3;
    public int sum;
    public int prev ;
    public int next ;
    public int tmpVal;
    public String tmpK1 ;
    public String tmpK2 ;
    public String tmpK3;
    public int tmpCon1;
    public int tmpCon2;
    public int tmpCon3;
    public int cur;
    public int totalSum;
    public List<String> threeDates = new ArrayList<String>();

    public int getLeastVal()
    {
        return leastVal;
    }
    public void setLeastVal(int leastVal)
    {
        this.leastVal =leastVal;
    }

    public List<String> getThreeDates()
    {
        return threeDates;
    }
    public void setThreeDates(List<String> threeDates)
    {
        this.threeDates =threeDates;
    }
    
    public void getLeastCars(Map<String,Integer> map){
          
        Map<Date,Integer> dateMap = new HashMap<Date,Integer>(); // new Hashmap
        LeastCars cl1 = new LeastCars(); // Initialised the class to access the global variables

        for (Map.Entry<String, Integer> entry : map.entrySet()) { //fetching the values from previous hashmap
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss"); 
                Date date = sdf.parse(entry.getKey());  //parse  string format to  date format
                dateMap.put(date,entry.getValue());  //add the date and car count to new Hashmap
            } 
            catch (ParseException e) {
                e.printStackTrace();
            } 
          }

         /** Sorting the date in descending order */
          Map<Date, Integer>  sorted = dateMap.entrySet()
          .stream()
          .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
          .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)); // sorting by key value

          Set<Date> keySet = sorted.keySet(); // Storing the keys of sorted Hashmap in SET 
          Date[] keyArray = keySet.toArray(new Date[keySet.size()]);
          DateFormat df = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");

          cl1.prev=0;
          cl1.cur =0;
          cl1.next=0;
       
        for(int i=2;i<sorted.size();i++){

            /** getting top 3 consecutive Dates(keys) */
            Date key1 = keyArray[i-2];
            Date key2 = keyArray[i-1];
            Date key3 = keyArray[i];
            /**getting  3 consecutive values */
            int value1 = sorted.get(key1);
            int value2 = sorted.get(key2);
            int value3 = sorted.get(key3);

            //long diff =  key1.getTime() - key2.getTime(); long min = TimeUnit.MILLISECONDS.toMinutes(diff); 
            int  sum =0;    
           if( key1.getTime() - key2.getTime()  == 1800000){  //checking for the 3 consecutive 1.5 hour difference
               if(key2.getTime() - key3.getTime()  == 1800000){
                
                sum = sum + sorted.get(key1)+sorted.get(key2)+sorted.get(key3);  // get the car counts of three 1.5 hour consecutive dates         
                    
                    cl1.k1=df.format(keyArray[i-2]); //formatting the date to String format
                    cl1.k2=df.format(keyArray[i-1]);
                    cl1.k3=df.format(keyArray[i]); 

            /** Checking the least car count value among all the 1.5 hour consecutive dates */

                if(cl1.prev < cl1.cur){  
                    cl1.tmpVal = cl1.prev;  
                    cl1.tmpCon1 = value1;   //storing the values & keys in tmp variables
                    cl1.tmpCon2 = value2;
                    cl1.tmpCon3 = value3;
                    cl1.tmpK1 = cl1.k1;
                    cl1.tmpK2 = cl1.k2;
                    cl1.tmpK3 = cl1.k3;
                }
                if(cl1.prev > cl1.cur)
                {
                    cl1.tmpVal = cl1.cur;  
                    cl1.tmpCon1 = value1;   //storing the values & keys in tmp variables
                    cl1.tmpCon2 = value2;
                    cl1.tmpCon3 = value3;
                    cl1.tmpK1 = cl1.k1;
                    cl1.tmpK2 = cl1.k2;
                    cl1.tmpK3 = cl1.k3;
                }
                cl1.prev = cl1.next;
                cl1.next = sum;                   
               }
           }

        }
        System.out.println("The 1.5 hour period with least cars : ");
        System.out.println();
        System.out.println(cl1.tmpK3 + " " + cl1.tmpCon3 + " , " + cl1.tmpK2 + " " + cl1.tmpCon2 + " , " + cl1.tmpK1 + " " + cl1.tmpCon1 + " = > " + cl1.next ); //fourth output
        System.out.println();

        List<String> li = new ArrayList<String>();
        li.add(cl1.tmpK1); li.add(cl1.tmpK2); li.add(cl1.tmpK3);
        setThreeDates(li); //storing the 1.5 hour consecutive dates and least car count in setters for unit test
        setLeastVal(cl1.next);

      }
    
}
