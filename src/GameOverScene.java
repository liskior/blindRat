package asyablindrat;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class GameOverScene extends Scene {
    public GameOverScene(Game game) {
        super(game);
    }

    public void update(long nanosPassed) {
        for (KeyEvent event : game.getKeyInput().getKeyPressedEvents()) {
            if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                game.setScene(new MainScene(game));
            }
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, game.getScreenSize().width, game.getScreenSize().height);

        g.setFont(new Font("Default", Font.BOLD, 16));
        g.setColor(Color.darkGray);

        String message = "Press <Enter> to start new game";
        Rectangle2D messageBounds = g.getFontMetrics().getStringBounds(message, g);
        int messageWidth = (int)(messageBounds.getWidth());
        int messageHeight = (int)(messageBounds.getHeight());

        g.drawString(message,
                game.getScreenSize().width / 2 - messageWidth / 2,
                game.getScreenSize().height / 2 - messageHeight / 2
        );
    }
}