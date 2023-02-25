// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriverWithHeading extends CommandBase {
  private double m_speed;
    private double m_disanceSP;
    private double m_headingSP;
    private DriveTrain m_drivetrain;
  /** Creates a new DriverWithHeading. */
  public DriverWithHeading(double speed, double disanceSP, double headingSP, DriveTrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_speed = speed;
    m_disanceSP = disanceSP;
    m_headingSP = headingSP;
    m_drivetrain = drivetrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.resetLeftEncoder();
    m_drivetrain.resetRightEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double turn = m_headingSP - m_drivetrain.getGyroDeg();
    double kp = .05;
    m_drivetrain.my_driveArcade(m_speed, turn * kp);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Drive off
    m_drivetrain.my_DriveStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_disanceSP) <= Math.abs(m_drivetrain.getLeftEncoder_Inches());
  }
}
