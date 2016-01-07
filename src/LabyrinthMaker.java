package asyablindrat;

public class LabyrinthMaker {
    public static int[][] buildLab(){
        int[][] wall = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        int i = 6, j = 0;
        while(j<wall.length-1){
            switch (nextStep()){
                case 1:
                    if(i>0) i--;
                    break;
                case 0:
                    j++;
                    break;
                case -1:
                    if(i<wall.length-1)i++;
            }
            wall[i][j] = 0;
        }
        for(int k=0; k<wall.length; k++) {
            for(int q=0; q<wall[0].length; q++) {
                System.out.print(wall[k][q]);
            }
            System.out.println();
        }
        return wall;
    }

    private static int nextStep() {
        double r = Math.random();
        System.out.println(r);
        if(r<0.33) return -1;
        if(r<0.67) return 0;
        return 1;
    }
}
