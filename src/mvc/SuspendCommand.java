public class SuspendCommand extends Command{
    public SuspendCommand(Model model){
        super(model);
    }
    @Override
    public void execute(){
        Simulation simulation = (Simulation)model;
        simulation.suspend();
    }
}

