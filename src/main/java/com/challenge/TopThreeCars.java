package com.challenge;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

import java.util.Collections;

public class TopThreeCars {

    public Map<String, Integer>  val = new HashMap<String,Integer>();

    public Map<String,Integer> getVal(){
        return val;
    }
    public void setVal(Map<String,Integer> tophalf)
    {
        this.val = tophalf;
    }

    public Map<String, Integer> sortVal = new HashMap<String, Integer>();

    public Map<String,Integer> getSortVal(){
        return sortVal;
    }
    public void setSortVal(Map<String,Integer> sortVal)
    {
        this.sortVal = sortVal;
    }
   
        public Map<String, Integer>  getTopThreeCars(String [][] arr)
        {
           int arr1[] =new int [arr.length];
            for(int i=0;i<arr.length;i++)
            {
                for(int j=1;j< 2;j++)
                {
                    arr1[i] = Integer.parseInt(arr[i][j]); //Storing the car counts in a new integer array
                    
                }
            }
            Map<String, Integer> map = new HashMap<>();
            for(int i=0;i<arr.length;i++)
            {
                for(int j=0;j<1;j++)
                {
                    map.put(arr[i][j],arr1[i]);  // Storing the unformatted date and car count in Hasmap with different data types.
                }
            }
            
         /* For sorting the count value, does ascending sort.
         
         LinkedList<Entry<String, Integer>> li = new LinkedList<Entry<String,Integer>>(map.entrySet());
            Collections.sort(li, new Comparator<Entry<String,Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }           
            });
            Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
            for (Map.Entry<String, Integer> entry : li) {
              sortedMap.put(entry.getKey(), entry.getValue());
              System.out.println("Key : " + entry.getKey()
              + " Value : " + entry.getValue());
            }*/
    
            /** Using Stream sorted() to do the descending sort on the car counts */

            Map<String, Integer>  sorted = map.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)); // Sorting by values of HashMap
    
            Set<String> keySet = sorted.keySet(); // Storing the keys of sorted Hashmap in SET to display the Key and Values
            String[] keyArray = keySet.toArray(new String[keySet.size()]);
            System.out.println("The top 3 half hours with most cars"); //Third output
            System.out.println();
            Map<String, Integer>  tophalf = new HashMap<String,Integer>(); // new Map to save the top 3 result, result to be stored in setter

            for(int i=0;i<3;i++){  // size is 3, since we are getting the top 3 values.
                String key = keyArray[i];  //fetch the key, which is unformatted date
                System.out.println(key+" " +sorted.get(key));  // display the value, which is the car count and also display the unformatted date
                tophalf.put(key, sorted.get(key)); // Storing the result in new map
  
            }
            System.out.println();
            setVal(tophalf); // top 3 value stored in setter
            setSortVal(sorted); // sorted unformatted map in setter

            return sorted;  // returning the unformatted date to solve the next question

                   
        }
    
    
}
