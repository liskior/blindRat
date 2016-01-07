package asyablindrat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;

public class KeyInput implements KeyListener {

    private final Collection<KeyEvent> keyPressedEvents;
    private final Collection<KeyEvent> keyRealisedEvents;

    public KeyInput() {
        keyPressedEvents = new ArrayList<KeyEvent>();
        keyRealisedEvents = new ArrayList<KeyEvent>();
    }

    public void keyTyped(KeyEvent e) {}

    public synchronized void keyPressed(KeyEvent e) {
        keyPressedEvents.add(e);
    }

    public synchronized Collection<KeyEvent> getKeyPressedEvents(){
        ArrayList<KeyEvent> events = new ArrayList<KeyEvent>(keyPressedEvents);
        keyPressedEvents.clear();
        return events;
    }

    public synchronized void keyReleased(KeyEvent e) {
        keyRealisedEvents.add(e);
    }

    public synchronized Collection<KeyEvent> getKeyRealisedEvents(){
        ArrayList<KeyEvent> events = new ArrayList<KeyEvent>(keyRealisedEvents);
        keyRealisedEvents.clear();
        return events;

    }
}
