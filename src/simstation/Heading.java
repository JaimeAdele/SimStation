package simstation;

import java.util.Random;

enum Direction {NORTH, EAST, SOUTH, WEST}

public class Heading {
    private static Random rand = new Random();

    private Direction direction;
    private int speed;

    static void random(Heading heading) {
        heading.direction = Direction.values()[rand.nextInt(Direction.values().length)];
        heading.speed = rand.nextInt(Agent.MAX_SPEED);
    }

    Heading() {
        direction = Direction.values()[rand.nextInt(Direction.values().length)];
        speed = rand.nextInt(Agent.MAX_SPEED);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setDirection(Direction d) {
        direction = d;
    }

    public void setSpeed(int s) {
        speed = s;
    }
}