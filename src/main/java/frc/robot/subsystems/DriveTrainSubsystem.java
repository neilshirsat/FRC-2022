package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.DriveTrainConstants;
import frc.robot.util.Component;

public class DriveTrainSubsystem extends SubsystemBase implements Component {

    private final DifferentialDrive differentialDrive;

    private final WPI_VictorSPX frontLeft;

    private final WPI_VictorSPX frontRight;

    private final WPI_VictorSPX backLeft;

    private final WPI_VictorSPX backRight;

    private final MotorControllerGroup leftMotorControllerGroup;

    private final MotorControllerGroup rightMotorControllerGroup;

    public DriveTrainSubsystem() {

        this.frontLeft = new WPI_VictorSPX(DriveTrainConstants.FRONT_LEFT);
        this.frontRight = new WPI_VictorSPX(DriveTrainConstants.FRONT_RIGHT);
        this.backLeft = new WPI_VictorSPX(DriveTrainConstants.BACK_LEFT);
        this.backRight = new WPI_VictorSPX(DriveTrainConstants.BACK_RIGHT);

        this.frontLeft.configFactoryDefault();
        this.frontRight.configFactoryDefault();
        this.backLeft.configFactoryDefault();
        this.backRight.configFactoryDefault();

        this.frontLeft.setNeutralMode(NeutralMode.Brake);
        this.frontRight.setNeutralMode(NeutralMode.Brake);
        this.backLeft.setNeutralMode(NeutralMode.Brake);
        this.backRight.setNeutralMode(NeutralMode.Brake);

        this.leftMotorControllerGroup = new MotorControllerGroup(this.frontLeft, this.backLeft);
        this.rightMotorControllerGroup = new MotorControllerGroup(this.frontRight, this.backRight);

        this.differentialDrive = new DifferentialDrive(
            this.leftMotorControllerGroup,
            this.rightMotorControllerGroup
        );

    }

    @Override
    public void constructor() {}

    public void arcadeDrive(double speed, double angle) {
        this.differentialDrive.arcadeDrive(speed, angle);
    }

    public void stop() {
        this.frontLeft.setVoltage(0);
        this.frontRight.setVoltage(0);
        this.backLeft.setVoltage(0);
        this.backRight.setVoltage(0);
    }
}
