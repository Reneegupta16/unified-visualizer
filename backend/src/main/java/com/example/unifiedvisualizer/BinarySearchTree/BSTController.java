package com.example.unifiedvisualizer.bst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bst")
public class BSTController {
    @Autowired
    private BSTService bstService;

    @PostMapping("/insert")
    public void insert(@RequestParam int key) {
        bstService.insert(key);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int key) {
        bstService.delete(key);
    }

    @GetMapping("/search")
    public boolean search(@RequestParam int key) {
        return bstService.search(key);
    }

    @GetMapping("/structure")
    public List<BSTService.NodeData> getTreeStructure() {
        return bstService.getTreeStructure();
    }
}
