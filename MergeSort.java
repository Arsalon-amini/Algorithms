package com.codeWithArsalon.Algorithms;

public class MergeSort {
    //recursively divides array into right / left sub arrays
    //merges smallest arrays recursively up the stack

    //O(n log n) time complexity!
    //log n - creating buckets
    //O(n) - comparing buckets
    //O(1) - merging buckets
    //O(n) space - reuse arrays in the stack

    public void sort (int [] array){
        if(array.length < 2) //array has single item, stop recursion
            return;

        var middle = array.length / 2; //divide into two

        int [] left = new int[middle]; //create left partition
        for (var i = 0; i < middle; i++) //copy array elements from array into left partition
            left [i] = array[i];

        int[] right = new int[array.length - middle]; //create right partition
        for (var i = middle; i < array.length; i++) //copy elements from array into right partition
            right [i - middle] = array[i]; //calculates index of array[i] to index right[0] new array

        sort(left); //recursively sort left and right partitions
        sort(right);

        merge(left, right, array); //merge result

    }

    private void merge(int [] left, int [] right, int [] result){
        int i = 0; //iterate left []
        int j = 0; //iterate right []
        int k = 0; //iterate result []

        while(i < left.length && j < right.length){
            if(left[i] <= right[j])
                result[k++] = left[i++]; //copying values from left into result array
            else
                result[k++] = right[j++];
        }

        while(i < left.length) //copy remaining items in left partition to result array
            result[k++] = left [i++];

        while(j < right.length)
            result[k++] = right[j++];

    }
}
