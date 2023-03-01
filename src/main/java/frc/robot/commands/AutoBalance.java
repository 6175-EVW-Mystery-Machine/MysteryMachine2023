// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoBalance extends SequentialCommandGroup {
  /** Creates a new AutoBalance. */
  public AutoBalance(DriveTrain m_drivetrain){
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveForDistance(86, -0.4, 0, m_drivetrain),
      new WaitCommand(0.25),
      new DriveForDistance(3.5, 0.4, 0, m_drivetrain),
      new DriveForDistance(4, -0.3, 0, m_drivetrain),
      new DriveToggleBreakMode(m_drivetrain),
      new WaitCommand(0.5),
     new DriveRotateToSetpoint(270, m_drivetrain),
     new DriveWithJoy(() ->-0.1, ()->0, m_drivetrain).withTimeout(0.75)

    );
  }
}
