package com.example.unifiedvisualizer.sorting;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SortService {

    public int[] bubbleSort(int[] array) {
        int n = array.length;
        int[] sortedArray = Arrays.copyOf(array, n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    public int[] quickSort(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        quickSortRec(sortedArray, 0, sortedArray.length - 1);
        return sortedArray;
    }

    private void quickSortRec(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSortRec(array, low, pi - 1);
            quickSortRec(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
