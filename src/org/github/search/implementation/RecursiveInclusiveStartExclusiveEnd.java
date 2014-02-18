package org.github.search.implementation;

import org.github.search.BinarySearcher;

public class RecursiveInclusiveStartExclusiveEnd implements BinarySearcher {
    @Override
    public int search(int num, int[] array) {
        return search(num, array, 0, array.length);
    }

    private int search(int num, int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return -1;
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if (num == array[middleIndex]) {
            return middleIndex;
        } else if (num < array[middleIndex]) {
            return search(num, array, startIndex, middleIndex);
        } else {
            return search(num, array, middleIndex, endIndex);
        }
    }
}
