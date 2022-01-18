package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.util.Component;
import frc.robot.util.Subsystem;

public class RetractIntakeCommand extends CommandBase implements Component {
    
    @Subsystem
    IntakeSubsystem intakeSubsystem;

    private boolean isExpanded;

    @Override
    public void constructor() {}

    @Override
    public void initialize() {
        if(isExpanded) {
            this.intakeSubsystem.setSolenoidValue(Value.kForward);
        }
        else {
            this.intakeSubsystem.setSolenoidValue(Value.kReverse);
        }
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        isExpanded = !isExpanded;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
