package su.levenetc.playground.java.generators;

import java.util.Random;

public class CityGenerator {

    Random rnd = new Random();

    public int[][] build(Config config) {
        int[][] result = new int[config.rows][config.cols];

        fillRoads(config, result);
        fillBuildings(config, result);

        return result;
    }

    private void fillBuildings(Config config, int[][] map) {

        int attempts = 3000;
        int id = 1;

        while (attempts > 0) {

            int rMin = rnd.nextInt(map.length - 1);
            int cMin = rnd.nextInt(map[0].length - 1);
            int rMax = rMin + rnd.nextInt(config.maxBuilding);
            int cMax = cMin + rnd.nextInt(config.maxBuilding);

            if (rMax > map.length - 1) rMax = map.length - 1;
            if (cMax > map[0].length - 1) cMax = map[0].length - 1;

            boolean filled = tryToFillSquare(map, rMin, rMax, cMin, cMax, City.BUILDING, id);

            if (filled) {
                id++;
            }

            attempts--;
        }
    }

    private void fillRoads(Config config, int[][] map) {
        int roads = config.roadsCount;

        while (roads > 0) {
            int row = (rnd.nextInt(config.cols - 1));
            int col = (rnd.nextInt((config.rows - 1)));

            if (map[row][col] == City.ROAD) continue;

            if (rnd.nextBoolean()) {
                fillColum(map, col, City.ROAD);
            } else {
                fillRow(map, row, City.ROAD);
            }

            roads--;
        }
    }

    private boolean tryToFillSquare(int[][] map, int rMin, int rMax, int cMin, int cMax, int value, int id) {

        value |= id;

        for (int r = rMin; r <= rMax; r++) {
            for (int c = cMin; c <= cMax; c++) {
                if (map[r][c] != 0) {
                    return false;
                }
            }
        }

        for (int r = rMin; r <= rMax; r++) {
            for (int c = cMin; c <= cMax; c++) {
                map[r][c] = value;
            }
        }

        return true;
    }

    private void fillCross(int[][] map, int rPoint, int cPoint, int value) {
        fillColum(map, cPoint, value);
        fillRow(map, rPoint, value);
    }

    private void fillRow(int[][] map, int r, int value) {
        for (int c = 0; c < map[0].length; c++) {
            map[r][c] = value;
        }
    }

    private void fillColum(int[][] map, int c, int value) {
        for (int r = 0; r < map.length; r++) {
            map[r][c] = value;
        }
    }

    static class City {

        static int EMPTY = 0;
        static int ROAD = 0x1;
        static int BUILDING = 0x11;
    }

    public static class Config {

        private int cols;
        private int rows;
        private int roadsCount;
        private int maxBuilding;
        private int minBuilding = 1;

        public Config() {

        }

        public Config maxBuilding(int value) {
            this.maxBuilding = value;
            return this;
        }

        public Config minBuilding(int value) {
            this.minBuilding = value;
            return this;
        }

        public Config cols(int value) {
            this.cols = value;
            return this;
        }

        public Config rows(int value) {
            this.rows = value;
            return this;
        }

        public Config roadsCount(int value) {
            this.roadsCount = value;
            return this;
        }

        public Config build() {
            return this;
        }


    }
}
