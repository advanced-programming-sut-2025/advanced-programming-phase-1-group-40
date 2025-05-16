package org.example.models;

public class WalkPoint {
    int x, y, dir, turns, dist;

        WalkPoint(int x, int y, int dir, int turns, int dist) {
            this.x = x;
            this.y = y;
            this.dir = dir;      // direction from which we came
            this.turns = turns;  // number of turns so far
            this.dist = dist;    // distance so far
        }
}
