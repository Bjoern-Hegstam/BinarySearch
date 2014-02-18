package org.github.search.implementation;

import org.github.search.BinarySearcher;

public class RecursiveInclusiveStartInclusiveEnd implements BinarySearcher {
    @Override
    public int search(int num, int[] array) {
        return search(num, array, 0, array.length - 1);
    }

    private int search(int num, int[] array, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        int middleIndex = startIndex + (endIndex + 1 - startIndex) / 2;
        if (num == array[middleIndex]) {
            return middleIndex;
        } else if (num < array[middleIndex]) {
            return search(num, array, startIndex, middleIndex - 1);
        } else {
            return search(num, array, middleIndex, endIndex);
        }
    }
}
