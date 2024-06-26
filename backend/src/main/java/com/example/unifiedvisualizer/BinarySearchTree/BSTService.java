package com.example.unifiedvisualizer.bst;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BSTService {
    private BinarySearchTree bst = new BinarySearchTree();

    public void insert(int key) {
        bst.insert(key);
    }

    public void delete(int key) {
        bst.deleteKey(key);
    }

    public boolean search(int key) {
        return bst.search(key);
    }

    public List<NodeData> getTreeStructure() {
        List<NodeData> nodes = new ArrayList<>();
        collectNodes(bst.getRoot(), null, nodes);
        return nodes;
    }

    private void collectNodes(BinarySearchTree.Node node, Integer parent, List<NodeData> nodes) {
        if (node != null) {
            nodes.add(new NodeData(node.key, parent));
            collectNodes(node.left, node.key, nodes);
            collectNodes(node.right, node.key, nodes);
        }
    }

    static class NodeData {
        int key;
        Integer parent;

        NodeData(int key, Integer parent) {
            this.key = key;
            this.parent = parent;
        }

        // Getters and setters
        public int getKey() { return key; }
        public void setKey(int key) { this.key = key; }

        public Integer getParent() { return parent; }
        public void setParent(Integer parent) { this.parent = parent; }
    }
}
