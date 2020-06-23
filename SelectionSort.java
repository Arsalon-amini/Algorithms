package com.codeWithArsalon.Algorithms;

public class SelectionSort {
    //ascending order
    //we select the minimum value (from unsorted part)
    //swap minValueIndexUnsorted with nextIndexSorted (next index in sorted part).

    //O(n) - swapping
    //O(n) - passes
    //O(n) * O(n) = quadratic time complexity!


    public void sort(int[] array) {
        for (var i = 0; i < array.length; i++) {
            var minIndex = i;
            for (var j = i; j < array.length; j++) //start search after previous min item
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                    swap(array, minIndex, i);
                }
        }
    }

    private void swap(int[] array, int newMinIndex, int oldMinIndex) {
        var selection = array[newMinIndex];
        array[newMinIndex] = array[oldMinIndex];
        array[oldMinIndex] = selection;
    }
}

