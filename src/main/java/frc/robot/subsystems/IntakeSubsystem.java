package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.IntakeConstants;
import frc.robot.util.Component;

/**
 * 
 * Intake Subsystem
 * 
 * Abstracts Control of the Pnumatics Components
 * of the Intake Subsystem
 * 
 * <p>
 * This Subsystem abstracts the control from the
 * Pnumatics System
 * 
 * @author Neil Shirsat
 */
public class IntakeSubsystem extends SubsystemBase implements Component {

    /**
     * The Abstraction of the Solenoid Controlling
     * both of the Pistons
     */
    private DoubleSolenoid intakeSolenoid;

    public IntakeSubsystem() {

        //Create the Intake Solenoid Object
        this.intakeSolenoid = new DoubleSolenoid( 
            PneumaticsModuleType.CTREPCM, 
            IntakeConstants.PISTON_FORWARD_ID, 
            IntakeConstants.PISTON_FORWARD_ID 
        );

    }

    @Override
    public void constructor() {
        
    }

    /**
     * @param value
     * 
     * <p>
     * Sets the New Solenoid Value to the Double
     * Solenoid of the Intake System
     */
    public void setSolenoidValue( DoubleSolenoid.Value value ) {
        this.intakeSolenoid.set(value);
    }

}
