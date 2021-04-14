package simstation;

import java.io.Serializable;
import java.util.Random;
import java.lang.Math;

enum AgentState {READY, RUNNING, SUSPENDED, STOPPED}


public abstract class Agent implements Serializable, Runnable {

    Random rand = new Random();
    static int MAX_SPEED = 5;

    private Simulation world;
    private String name;
    private Heading heading;
    private int xPosition;
    private int yPosition;
    private AgentState state;
    private Thread myThread;

    public Agent() {
        heading = new Heading();
        xPosition = rand.nextInt(Simulation.WORLD_DIMENSION);
        yPosition = rand.nextInt(Simulation.WORLD_DIMENSION);
    }

    public void setName(String simName) {
        name = simName;
    }

    public String getName() {
        return name;
    }

    //-----------------------------------------------
    public void run() {
        myThread = Thread.currentThread();
        while(state == AgentState.RUNNING) {
            try {
                update();
                Thread.sleep(100);

            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }
        }
    }
    //-----------------------------------------------

    public void start() {
        state = AgentState.READY;
    }

    public void suspend() {
        state = AgentState.SUSPENDED;
    }

    public void resume() {
        state = AgentState.READY;
    }

    public void stop() {
        state = AgentState.STOPPED;
    }

    abstract public void update();

    public void move(int steps) {
        switch (heading.getDirection()) {
            case NORTH:
                yPosition -= steps;
                break;
            case EAST:
                xPosition += steps;
                break;
            case SOUTH:
                yPosition += steps;
                break;
            case WEST:
                xPosition -= steps;

        }
    }

    public double distance(Agent other) {
        return Math.sqrt((this.xPosition - other.xPosition) * (this.xPosition - other.xPosition) + (this.yPosition - other.yPosition) * (this.yPosition - other.yPosition));
    }
}
