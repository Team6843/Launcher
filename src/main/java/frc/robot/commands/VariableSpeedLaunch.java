/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LauncherSubsystem;

public class VariableSpeedLaunch extends CommandBase {
  final LauncherSubsystem m_launcherSubsystem;
  final Supplier<Double> m_speedSupplier;
  /**
   * Spins the launcher motors at whatever speed is supplied to it
   * @param speedSupplier Supplier<Double> of the speed
   * @author JSamson
   */
  public VariableSpeedLaunch(LauncherSubsystem launcherSubsystem,
      Supplier<Double> speedSupplier) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_launcherSubsystem = launcherSubsystem;
    m_speedSupplier = speedSupplier;
    addRequirements(launcherSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_launcherSubsystem.variableSpeed(m_speedSupplier.get());
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
