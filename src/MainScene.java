package asyablindrat;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainScene extends Scene {
    private Rat rat;
    private Labyrinth labyrinth;
    private Delay delay;
    public MainScene(Game game) {
        super(game);
        rat = new Rat(0, Constants.WORLD_HEIGHT/2, Direction.RIGHT);
        labyrinth = new Labyrinth();
        delay = new Delay(300);
    }

    public void update(long nanosPassed) {
        if(rat.getY()==Constants.WORLD_WIDTH-1){
            game.setScene(new GameOverScene(game));
        }
        processInput();
        if (delay.updateAndCheck(nanosPassed)) {
            int x = rat.getX();
            int y = rat.getY();
            rat.move();
            System.out.println(rat.getX()+" "+rat.getY());
            if (rat.getY() == -1 || rat.getX()==-1 || rat.getX()==game.getScreenSize().height) {
                rat.setY(y);
                rat.setX(x);
            } else if (labyrinth.get(rat.getX(), rat.getY()) != 0) {
                if (rat.getDirection() == Direction.DOWN || rat.getDirection() == Direction.UP) {
                    labyrinth.wall[rat.getX()][rat.getY()] = 3000;
                } else if (rat.getY() != 0) {
                    labyrinth.wall[rat.getX()][rat.getY()] = -3000;
                }
                rat.setX(x);
                rat.setY(y);

            }
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.PINK);
        g.fillRect(0, 0, game.getScreenSize().width, game.getScreenSize().height);
        
        drawRat(g);
        drawBorders(g);
    }
    private void drawRat(Graphics2D g){
        g.setColor(Color.DARK_GRAY);
        int width, height;
        if(rat.getDirection()==Direction.DOWN||rat.getDirection()==Direction.UP){
            width = Constants.CELL_SIZE/2;
            height = Constants.CELL_SIZE;
        }
        else{
            width = Constants.CELL_SIZE;
            height = Constants.CELL_SIZE/2;
        }
        g.fillOval(rat.getY() * Constants.CELL_SIZE,
                game.getScreenSize().height - (rat.getX() * Constants.CELL_SIZE),
                width,
                height);
    }
    private void drawBorders(Graphics2D g){
        g.setColor(Color.red);
        for(int i=0; i<labyrinth.wall.length; i++){
            for(int j=0; j<labyrinth.wall[0].length; j++){
                if(labyrinth.get(i, j)!=1&&labyrinth.get(i, j)!=-1&&labyrinth.get(i, j)!=0){
                    g.fillRect(j*Constants.CELL_SIZE,
                            game.getScreenSize().height - (i)*Constants.CELL_SIZE,
                            Constants.CELL_SIZE,
                            Constants.CELL_SIZE
                            );
                    labyrinth.wall[i][j] = (labyrinth.get(i, j)>0)?labyrinth.wall[i][j]-1:labyrinth.wall[i][j]+1;
                }
            }
        }

    }

    private void processInput() {
        for (KeyEvent event : game.getKeyInput().getKeyPressedEvents()) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP:
                    rat.setDirection(Direction.UP);
                    break;
                case KeyEvent.VK_RIGHT:
                    rat.setDirection(Direction.RIGHT);
                    break;
                case KeyEvent.VK_DOWN:
                    rat.setDirection(Direction.DOWN);
                    break;
                case KeyEvent.VK_LEFT:
                    rat.setDirection(Direction.LEFT);
                    break;
            }
        }
    }
}
