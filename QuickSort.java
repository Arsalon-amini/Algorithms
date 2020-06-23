package com.codeWithArsalon.Algorithms;

public class QuickSort {
    //ranges from O(n log n) to (n^2)

    public void sort (int [] array){
        sort(array, 0, array.length - 1);
    }

    private void sort(int [] array, int start, int end){
        if(start >= end) // recursive stop, means single item array
            return;

        var boundary = partition(array, start, end); //end = index of last item in segment working with

        sort(array, start, boundary - 1); //start = start of left partition, boundary - 1 = pivot
        sort(array, boundary + 1, end); //right partition starts after boundary (b + 1), goes to end of array
    }

    private int partition (int [] array, int start, int end){
        var pivot = array[end]; //set pivot as last item in segment working with
        var boundary = start - 1; //initially left partition is empty
        for (var i = start; i <= end; i++){
            if (array[i] <= pivot){
                boundary++;
                swap(array, i, boundary);
            }
        }
        return boundary; //boundary after pivot moved into place
    }

    private void swap (int [] array, int indexOne, int indexTwo){
        var temp = array [indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}




