package asyablindrat;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class CanvasGame extends Canvas implements Game, Runnable{

    private Thread gameThread;

    private AtomicBoolean running;

    private KeyInput keyInput;
    private Scene scene;

    public void start() {
        if (running.compareAndSet(false, true)) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    public CanvasGame(Dimension screenSize) {
        running = new AtomicBoolean(false);
        setSize(screenSize);
        initKeyInput();
        initFocusListener();

    }

    private void initFocusListener() {
        addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent event) {
                start();
            }

            public void focusLost(FocusEvent event) {
                pause();
            }
        });
    }

    private void initKeyInput() {
        keyInput = new KeyInput();
        addKeyListener(keyInput);
    }

    public void pause() {
        if (running.compareAndSet(true, false)) {
            try {
                gameThread.join();
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public Dimension getScreenSize() {
        return getSize();
    }

    public KeyInput getKeyInput() {
        return keyInput;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void falseRunning() {
        running.set(false);
    }

    public void run() {
        long previousIterationTime = System.nanoTime();
        while (running.get()) {
            if (scene == null) {
                continue;
            }
            long now = System.nanoTime();
            long nanosPassed = now - previousIterationTime;
            previousIterationTime = now;
            Graphics2D g = (Graphics2D)getBufferStrategy().getDrawGraphics();
            scene.update(nanosPassed);
            scene.draw(g);
            getBufferStrategy().show();
        }
    }
}
