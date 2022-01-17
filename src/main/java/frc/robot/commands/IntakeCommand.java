package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.util.Component;

/**
 * Intake Command
 * 
 * <p>
 * Commands the Intake Subsystem to Intake a Ball
 * 
 * <p>
 * When Intaking a Ball, the Speed of the Motor will
 * transition in a Bezier Function to Smoothly Intake
 * the Ball
 * 
 * @author Neil Shirsat
 */
public class IntakeCommand extends CommandBase implements Component {

    @Override
    public void constructor() {
        
    }

    /**
     * 
     */
    @Override
    public void initialize() {}

    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }

}
