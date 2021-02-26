// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LauncherSubsystem;

public class DashboardSpeed extends CommandBase {
  final LauncherSubsystem m_launcherSubsystem;
  /**
   * Sets the launcher motors to the speed passed in by the smartDashboard
   * @author JSamson
   */
  public DashboardSpeed(LauncherSubsystem launcherSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_launcherSubsystem = launcherSubsystem;
    addRequirements(launcherSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_launcherSubsystem.dashboardSpeed();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_launcherSubsystem.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
