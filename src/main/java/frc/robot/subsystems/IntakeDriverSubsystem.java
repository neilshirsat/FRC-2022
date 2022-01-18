package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.IntakeConstants;
import frc.robot.util.Component;

/**
 * Intake Driver Subsystem
 * 
 * <p>
 * Abstracts the Intake Driver System
 * 
 * <p>
 * The Intake Driver Controls the Speed,
 * Torque, etc of the Motor that controls
 * the wheels which intake the balls
 * 
 * @author Neil Shirsat
 */
public class IntakeDriverSubsystem extends SubsystemBase implements Component {

    /**
     * The Motor that Controls the Wheels
     * of the Intake
     */
    private WPI_VictorSPX intakeMotor;
    
    public IntakeDriverSubsystem() {

        this.intakeMotor = new WPI_VictorSPX(IntakeConstants.MOTOR_DEVICE_ID);
        this.intakeMotor.configFactoryDefault();
        this.intakeMotor.setNeutralMode(NeutralMode.Brake);

    }

    @Override
    public void constructor() {
        
    }
    
    /**
     * Set the Speed of the Motor
     * 
     * @param speed
     */
    public void setSpeed( double speed ) {
        this.intakeMotor.set(speed);
    }

    /**
     * Stop the Motor
     * 
     * <p>
     * Sets the Voltage of the Motor to 0
     * so that the Motor stops running
     */
    public void stopMotor() {
        this.setSpeed(0);
    }

}
