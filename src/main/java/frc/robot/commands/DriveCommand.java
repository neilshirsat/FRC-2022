package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.container.Axes;
import frc.robot.container.OI;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.util.Component;
import frc.robot.util.Injectable;
import frc.robot.util.Subsystem;

/** @author Neil */
public class DriveCommand extends CommandBase implements Component {

    @Subsystem
    DriveTrainSubsystem driveTrainSubsystem;
    
    @Injectable
    OI oi; // what are these names?

    @Override
    public void constructor() {
        this.addRequirements(driveTrainSubsystem);
    }

    @Override
    public void execute() {
        this.driveTrainSubsystem.arcadeDrive(oi.getAxis(0, Axes.LEFT_STICK_Y), oi.getAxis(0, Axes.RIGHT_STICK_X));
    }
    
    @Override
    public void end(boolean interrupted) {
	this.driveTrainSubsystem.stop();
    }
	
    @Override
    public boolean isFinished() {
	return false;
    }
}
