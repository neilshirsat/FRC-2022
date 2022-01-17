// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.container;

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

    public RobotContainer() {

        this.componentFactory = new ComponentFactory();
        componentFactory.registerService(new BallStore());
        componentFactory.registerSubsystem(new IntakeSubsystem());
        componentFactory.registerSubsystem(new IntakeDriverSubsystem());

    }

}
