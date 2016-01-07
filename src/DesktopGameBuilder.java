package asyablindrat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class DesktopGameBuilder {

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int screenWidth = Constants.WORLD_WIDTH * Constants.CELL_SIZE;
            int screenHeight = Constants.WORLD_HEIGHT * Constants.CELL_SIZE;
            Dimension screenSize = new Dimension(screenWidth, screenHeight);
            Game game = DesktopGameBuilder.build(screenSize);
            game.setScene(new MainScene(game));
            game.start();
        }
    }
    public static Game build(Dimension screenSize) {
        final CanvasGame game = new CanvasGame(screenSize);
        JFrame frame = new JFrame("Blind Rat");
        frame.setFocusable(false);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        game.createBufferStrategy(2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                game.pause();
            }
        });
        frame.requestFocus();
        game.requestFocus();
        return game;
    }
}
