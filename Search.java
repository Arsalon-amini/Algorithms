package com.codeWithArsalon.Algorithms;
//linearSearch - O(n) have to make n comparisions
//BinarySearchRec - O(log n) search x O(n log n) bucketSort - divide and conquer algorithm [only works on sorted lists]
//BinarySearchIter - O(log n) search, less space (don't need to store recursive calls on stack)
//ternarySearch - O(log n)
//jumpSearch - O(squareroot(n))
//exponentialSearch - O (log i)

public class Search {
    public int linearSearch(int [] array, int target){
        for (var i = 0; i < array.length; i++)
            if(array[i] == target)
                return i; //return index of item

        return -1; //item not found after iterating entire list
    }

    public int binarySearchRecursive(int [] array, int target){
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    private int binarySearchRecursive(int [] array, int target, int left, int right){
        if (right < left) //empty array
            return -1;

        int middle = (left + right) / 2;

        if (array[middle] == target)
            return middle;

        if(target < array[middle])
            return binarySearchRecursive(array, target, left, middle - 1); //target item is in left partition

        return binarySearchRecursive(array, target, middle + 1, right); //target item is in right partition
    }

    public int binarySearch(int [] array, int target){
        var left = 0;
        var right = array.length - 1;

        while (left <= right){
            var middle = (left + right) / 2; //calculate middle index

            if(array[middle] == target) //check if middle item = value
                return middle;

            if (target < array[middle])
                right = middle - 1; //update right pointer
            else
                left = middle + 1; //update left pointer
        }

        return -1; //doesn't exist in list
    }

    public int ternarySearch(int [] array, int target){
        return ternarySearch(array, target, 0, array.length - 1);
    }

    private int ternarySearch(int [] array, int target, int left, int right){

        if(left > right) //base condition
            return - 1;

        int partitionSize = (right - left) / 3;
        int middleOne = left + partitionSize;
        int middleTwo = right - partitionSize;

        if(array[middleOne] == target)
            return middleOne;

        if(array[middleTwo] == target)
            return middleTwo;

        if(target < array[middleOne]) //means value is in left partition
            return ternarySearch(array, target, left, middleOne - 1);

        if(target > array[middleTwo])
            return ternarySearch(array, target, middleTwo + 1, right);

        return ternarySearch(array, target, middleOne + 1, middleTwo - 1);
    }

    public int jumpSearch(int [] array, int target){
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        while (start < array.length && array[next - 1] < target){ //compare last item in block (next - 1) to target
            start = next; //advance pointer to next block

            next += blockSize;
            if(next > array.length) //edge case, pointer outside array indices
                next = array.length;
        }

        for (var i = start; i < next; i++) //linear search on block w/ potential target value
            if (array[i] == target)
                return i;

            return -1;
    }

    public int exponentialSearch(int [] array, int target){
        int bound = 1;
        while(bound < array.length && target > array[bound])
            bound *=2; //bound = bound x 2

        int left = bound / 2; //index of last bound
        int right = Math.min(bound, array.length - 1 ); //calc size of block to search w/in

        return binarySearchRecursive(array, target, left, right); //search within block range bound / 2 to bound (right side)
    }
}



