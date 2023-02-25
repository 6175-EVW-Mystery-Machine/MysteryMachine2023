// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveRotateToSetpoint extends PIDCommand {
  /** Creates a new DriveRotateToSetpoint. */
  public DriveRotateToSetpoint(double setpoint, DriveTrain driveTrain) {
    super(
        // The controller that the command will use
        new PIDController(.05, 0, 0),
        // This should return the measurement
        driveTrain::getGyroDeg,
        // This should return the setpoint (can also be a constant)
        setpoint,
        // This uses the output
        output -> driveTrain.my_driveArcade(0.0, MathUtil.clamp(output, -0.3, 0.3)));
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    // Configure additional PID options by calling `getController` here.
    getController().enableContinuousInput(-180, 180);
    getController()
        .setTolerance(2, 45);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
