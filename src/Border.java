package asyablindrat;

import java.awt.*;

public class Border {

    private int visible;
    private Dimension d1, d2;

    public Border(Dimension d1, Dimension d2) {
        this.d2 = d2;
        this.visible = 0;
        this.d1 = d1;

    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public void setD1(Dimension d1) {
        this.d1 = d1;
    }

    public void setD2(Dimension d2) {
        this.d2 = d2;
    }
}
