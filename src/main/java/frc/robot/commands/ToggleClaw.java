// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Claw;

public class ToggleClaw extends InstantCommand {
  private final Claw m_claw;
  private boolean m_isClawOpen;
  /** Creates a new ToggleClaw. */
  public ToggleClaw(boolean m_isClawOpen, Claw claw) {
    m_claw = claw;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_claw.setClawToggle(!m_claw.get_isClawOpen());
  }

  @Override
    public boolean runsWhenDisabled() {
        
        return true;

    }
}
