package com.example.unifiedvisualizer.pathfinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pathfinding")
public class PathfindingController {
    @Autowired
    private PathfindingService pathfindingService;

    @PostMapping("/dijkstra")
    public List<int[]> dijkstra(@RequestBody PathfindingRequest request) {
        return pathfindingService.dijkstra(request.getGrid(), request.getStart(), request.getEnd());
    }

    @PostMapping("/astar")
    public List<int[]> aStar(@RequestBody PathfindingRequest request) {
        return pathfindingService.aStar(request.getGrid(), request.getStart(), request.getEnd());
    }
}
