package com.codeWithArsalon.Algorithms;

public class InsertionSort {
    //shifts items to make space

    //O(n) * O(n) = quadratic time complexity
    //O(n) - shifting
    //O(n) - comparisons


    public void sort (int [] array){
        for (var i = 1; i < array.length; i++){
            var current = array[i];
            var j = i - 1;
            while(j >= 0 && array[j] > current){
                array[j + 1] = array [j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}


