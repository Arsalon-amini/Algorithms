package com.codeWithArsalon.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    //range from O(n) to O(n^2)
    //O(n^2) for single bucket (worst case) using quicksort algorithm
    //O(n) for many buckets single buckets (best case)

    public void sort (int [] array, int numberOfBuckets) {
        var i = 0;
        for (var bucket : createBuckets(array, numberOfBuckets)) {
            Collections.sort(bucket); //Collection has sort method which implements quicksort to sort each bucket
            for (var item : bucket) //iterate over bucket, insert into input array
                array[i++] = item;
        }
    }

        private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets){
            List<List<Integer>> buckets = new ArrayList<>(); //list of linkedLists
            for (var i = 0; i < numberOfBuckets; i++)// program against null pointer exceptions
                buckets.add(new ArrayList<>());

            for (var item : array) //distribute items into buckets
                buckets.get(item / numberOfBuckets).add(item);

            return buckets;
        }
    }

