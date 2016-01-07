package asyablindrat;

import java.awt.*;

public interface Game {
    void start();
    void pause();
    Dimension getScreenSize();
    KeyInput getKeyInput();
    void setScene(Scene scene);

    void falseRunning();
}
