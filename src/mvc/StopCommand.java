public class StopCommand extends Command {
    public StopCommand(Model model){
        super(model);
    }
    @Override
    public void execute(){
        Simulation simulation = (Simulation) model;
        simulation.stop();
    }
}
