package org.example.models;

public class WalkResult {
        int distance;
        int turns;

        WalkResult(int distance, int turns) {
            this.distance = distance;
            this.turns = turns;
        }

        public int getDistance() {
            return distance;
        }

        public int getTurns() {
            return turns;
        }
}

