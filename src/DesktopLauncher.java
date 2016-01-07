package asyablindrat;

import java.awt.*;
public class DesktopLauncher {
    public static void main(String[] args) {
        int screenWidth = Constants.WORLD_WIDTH * Constants.CELL_SIZE;
        int screenHeight = Constants.WORLD_HEIGHT * Constants.CELL_SIZE;
        Dimension screenSize = new Dimension(screenWidth, screenHeight);
        Game game = DesktopGameBuilder.build(screenSize);
        game.setScene(new MainScene(game));
        game.start();
    }
}
