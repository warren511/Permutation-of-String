package com.and.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;
import java.util.stream.*;

public class Solution {
    /**
     * The following is the method where the solution shall be written
     */   
    public static String solution (String input) throws NumberFormatException {//function to filter integers only
        
        ArrayList userInputToInt = new ArrayList(); // create a new blank array
              
        for (int i = 0; i < input.length(); i++) { //for loop to iterate through the user input to select integers         
            char c = input.charAt(i); // variable c of char type is assigned to return character at specified index in loop             
            if (Character.isDigit(c)) { 
                userInputToInt.add(c);//if the character is an integer, it gets added into the user input which is used in the program
            }    
        }
        
        String filterInputStr = (String) userInputToInt.stream().map(Object::toString).collect(Collectors.joining()); //convert userIntInput objects into a string through mapping
       
        if (filterInputStr.equals("")) {
            return "Please ensure integers are used in your input"; // excluding any odd entries first for faster compiling of code
        } else {
            Set<String> set = permutation(filterInputStr); // a set is used so the same element is not duplicated
   
            String output = (String) set.stream().map(Object::toString).collect(Collectors.joining(",")); // map the set into a string
            return output; //output converted into string from set so it can be shown to user
        }
    }

    public static Set<String> permutation (String characters) {
         
        Set<String> set = new TreeSet<String>(); //a Tree set is used so the same element is not duplicated

        if (characters.length() == 1) {// excluding any odd entries first for faster compiling of code
            set.add(characters);
        } else {
            for (int i = 0; i < characters.length(); i++) { // Each character has a chance to be the first in the permuted string
                String prefix = characters.substring(0, i); // Remove the character at index i from the string using substring method
                String post = characters.substring(i + 1); //remaining charatcters in the string
                String remaining = prefix + post; //adding them together so it is as : ("pre", "post")

                for (String permute : permutation(remaining)) { // all the permutations of the remaining chars are obtained through recursion
                    set.add(characters.charAt(i) + permute); // concatenate the result into a set
                
                //process is repeated for all of the other possible combinations    
                }
            }
        }
        return set;
    }
    
        public static void main(String args[]) {
        System.out.println(solution("234"));
    } 
    
}
