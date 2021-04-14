package simstation;

import mvc.*;
import java.util.Random;

import java.util.LinkedList;

public class Simulation extends Model {
    Random rand = new Random();
    static int POPULATION_SIZE = 250;
    static int WORLD_DIMENSION = 500;
    //private Timer timer;
    private int clock;
    private LinkedList<Agent> agents;

    public Simulation() {
        agents = new LinkedList<Agent>();
        clock = 0;
    }

    public void start() {
        agents = new LinkedList<Agent>();
        clock = 0;
        populate();
        //startTimer();
        for (Agent a : agents) {
            Thread thread = new Thread(a);
            thread.start();
        }
    }

    public synchronized void suspend() {
        for (Agent a : agents) {
            a.suspend();
        }
        //stopTimer();
    }

    public synchronized void resume() {
        //startTimer();
        for (Agent a : agents) {
            a.resume();
        }
    }

    public synchronized void stop() {

    }

    public synchronized Agent getNeighbor(Agent a, double radius) {
        Agent neighbor = null;
        boolean found = false;
        int i = rand.nextInt(agents.size());
        int start = i;
        while (!found) {
            Agent candidate = agents.get(i);
            if (candidate != a && a.distance(candidate) < radius) {
                neighbor = agents.get(i);
                found = true;
            } else {
                i = (i + 1) % agents.size();
                if (i == start) {
                    break;
                }
            }
        }
        return neighbor;
    }

    public void populate() {}
}
