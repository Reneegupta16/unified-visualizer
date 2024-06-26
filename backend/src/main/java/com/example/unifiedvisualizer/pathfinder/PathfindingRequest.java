package com.example.unifiedvisualizer.pathfinding;

public class PathfindingRequest {
    private int[][] grid;
    private int[] start;
    private int[] end;

    // Getters and setters
    public int[][] getGrid() { return grid; }
    public void setGrid(int[][] grid) { this.grid = grid; }

    public int[] getStart() { return start; }
    public void setStart(int[] start) { this.start = start; }

    public int[] getEnd() { return end; }
    public void setEnd(int[] end) { this.end = end; }
}
