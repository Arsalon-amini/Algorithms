package com.codeWithArsalon.Algorithms;

public class CountingSort {
    //O(n) time complexity
    //O(k) space complexity
    //values in list must be positive integers (cannot use negative for indexes in counts array)

    public void sort(int [] array, int max){
        int [] counts = new int[max + 1]; //array size = max value in input range
        for (var item : array) //iterate input array
            counts[item]++; // use item as index in counts array, if index present, increment value at index

        var k = 0; //repopulate our input array w/ count data
        for(var i = 0; i < counts.length; i++) //iterate counts array
            for(var j = 0; j < counts[i]; j++) //iterate bucket at each index in count array
                array[k++] = i;
    }
}
