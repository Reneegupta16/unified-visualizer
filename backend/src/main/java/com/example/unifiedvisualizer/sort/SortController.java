package com.example.unifiedvisualizer.sorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sort")
public class SortController {
    @Autowired
    private SortService sortService;

    @PostMapping("/bubble")
    public int[] bubbleSort(@RequestBody int[] array) {
        return sortService.bubbleSort(array);
    }

    @PostMapping("/quick")
    public int[] quickSort(@RequestBody int[] array) {
        return sortService.quickSort(array);
    }
}
