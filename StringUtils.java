package com.codeWithArsalon.Algorithms;

import java.util.*;

public class StringUtils {
    public static int countVowels(String str){
        if(str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";
        for(var ch : str.toLowerCase().toCharArray())
            if(vowels.contains(Character.toString(ch))) //iterate over every char, could use Set instead (faster)
                count++;

            return count;
    }

    public static String reverse(String str){
        if (str == null)
            return ""; //return empty string vs. null (prevent other null ptr exceptions)

        StringBuilder reversed = new StringBuilder();
        for(var i = str.length() - 1; i >= 0; i--) //O(n)
            reversed.append(str.charAt(i)); //O(1)

        return reversed.toString();
    }

    public static String reverseWords(String sentence){
        if (sentence == null)
            return "";

        String [] words = sentence.trim().split(" "); //remove whitespaces at start/end, then separate by whitespace, returns string array
        Collections.reverse(Arrays.asList(words)); //converts array to list that reverse can work on
        return String.join(" ", words); //join items based on whitespace, return array
    }

    public static boolean areRotations(String str1, String str2){
        if (str1 == null || str2 == null)
            return false;

        if(str1.length() != str2.length())
            return false;

        var concat = str1 + str2;
        return (str1.length() == str2.length() && (str1 + str1).contains(str2));

    }

    public static String removeDuplicates(String str){
        if(str == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }

    public static char getMaxOccurringChar(String str){
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;
        int [] frequencies = new int[ASCII_SIZE]; //represents ASCII table
        for( var ch : str. toCharArray())
            frequencies[ch]++; //JVM converts ch to numeric representation (ASCII value), can use as array index, increment value at index +1

        int max = 0;  //if find larger item in frequencies, will update max
        char result = ' ';
        for (var i = 0; i < frequencies.length; i++)
            if(frequencies[i] > max) { //find largest value in frequencies array
                max = frequencies[i]; //set largest value to max
                result = (char) i; //convert integer to ch
            }

        return result;
    }

    public static String capitalize(String sentence){
        if(sentence.trim().isEmpty())
            return "";

        String [] words = sentence
                .trim() //trims whitespace on front/end of string
                .replaceAll(" +", " ") //replaces any spot with multiple whitespaces with single whitespace
                .split(" "); //break sentence up, store each word, split by whitespace

        for(var i = 0; i < words.length; i++){
            words[i] = words[i].substring(0, 1).toUpperCase() //gets word at index i, gets letter 0 - 1 (first letter), uppercase
            + words[i].substring(1).toLowerCase(); //return all chars starting at index 1
        }
        return String.join(" ", words); //join words in array at white space
    }

    public static boolean areAnagrams(
            String first, String second
    ){
        if(first == null || second == null ||
           first.length() != second.length()) //added if strings are million of chars long, .length = O(1) operation!
            return false;

        var arrayOne = first.toLowerCase().toCharArray();
        Arrays.sort(arrayOne);

        var arrayTwo = second.toLowerCase().toCharArray();
        Arrays.sort(arrayTwo);

        return Arrays.equals(arrayOne, arrayTwo);
    }
}




