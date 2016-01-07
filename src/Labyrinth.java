package asyablindrat;

public class Labyrinth {
    public int get(int i, int j) {
        return wall[i][j];
    }

    int[][] wall = new int[Constants.WORLD_HEIGHT][Constants.WORLD_WIDTH];

    public Labyrinth(){
        this.wall = LabyrinthMaker.buildLab();
    }
}
