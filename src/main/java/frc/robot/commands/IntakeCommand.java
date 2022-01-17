package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.IntakeConstants;
import frc.robot.subsystems.IntakeDriverSubsystem;
import frc.robot.util.Component;
import frc.robot.util.Subsystem;

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

    @Subsystem
    IntakeDriverSubsystem intakeDriverSubsystem;

    int time = 0;

    @Override
    public void constructor() {}

    @Override
    public void initialize() {
        time = 0;
        intakeDriverSubsystem.setSpeed(0.75);
    }

    @Override
    public void execute() {
        time += 20;
    }

    @Override
    public void end(boolean interrupted) {
        intakeDriverSubsystem.stopMotor();
    }

    @Override
    public boolean isFinished() {
        if (time >= IntakeConstants.BALL_INTAKE_TIME) {
            return true;
        }
        else {
            return false;
        }
    }

}
