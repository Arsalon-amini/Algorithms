package com.codeWithArsalon.Algorithms;

public class BubbleSort {
    // each pass next largest number moves into position (ascending order)

    //O(n) * O(n) = quadratic time complexity!
    //O(n) - passes (worst case)
    //O(n) - comparisons



    public void sort(int [] array) {
        boolean isSorted; //reduce O(n) iterations if already sorted
        for (var i = 0; i < array.length; i++) {
            isSorted = true;
            for (var j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

    private void swap (int [] array, int indexOne, int indexTwo){
        var temp = array [indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
