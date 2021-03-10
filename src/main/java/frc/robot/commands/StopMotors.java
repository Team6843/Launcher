/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.LoaderSubsystem;

public class StopMotors extends CommandBase {
  final LauncherSubsystem m_launcherSubsystem;
  final LoaderSubsystem m_loaderSubsystem;
  /**
   * Stops all the motors
   * @author JSamson
   */
  public StopMotors(LauncherSubsystem launcherSubsystem, LoaderSubsystem loaderSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_launcherSubsystem = launcherSubsystem;
    m_loaderSubsystem = loaderSubsystem;
    addRequirements(launcherSubsystem);
    addRequirements(loaderSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_launcherSubsystem.stopMotors();
    m_loaderSubsystem.stopMotors();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
