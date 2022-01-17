// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.container;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.IntakeCommand;
import frc.robot.global.BallStore;
import frc.robot.subsystems.IntakeDriverSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * 
 * Intializes and Configures the IOC Container of the
 * Robot
 * 
 * @author Neil Shirsat
 */
public class RobotContainer {

    private final ComponentFactory componentFactory;

    private final OI oi;

    private CommandBase intakeCommand;

    public RobotContainer() {

        this.componentFactory = new ComponentFactory();
        componentFactory.registerService(new BallStore());
        componentFactory.registerSubsystem(new IntakeSubsystem());
        componentFactory.registerSubsystem(new IntakeDriverSubsystem());

        oi = new OI();
        configureButtonBindings();

    }

    private void configureButtonBindings() {
		
        intakeCommand = componentFactory.createCommand(IntakeCommand.class);
        oi.getButton(1, Buttons.B_BUTTON).whenPressed(intakeCommand);

	}

}
