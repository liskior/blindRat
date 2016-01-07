package asyablindrat;

public class Rat {
    int x, y;
    private  Direction direction;

    public Rat(int y, int x, Direction direction) {
        this.y = y;
        this.x = x;
        this.direction = direction;
    }

    public void move(){
        setX(getX()+getDirection().deltaX());
        setY(getY()+getDirection().deltaY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
