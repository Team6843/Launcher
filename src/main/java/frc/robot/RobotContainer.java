/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DashboardSpeed;
import frc.robot.commands.SetSpeedLaunch;
import frc.robot.commands.SpinWheel;
import frc.robot.commands.StopMotors;
import frc.robot.commands.T100B25Launch;
import frc.robot.commands.T100B50Launch;
import frc.robot.commands.T100B75Launch;
import frc.robot.commands.T25B100Launch;
import frc.robot.commands.T50B100Launch;
import frc.robot.commands.T75B100Launch;
import frc.robot.commands.VariableSpeedLaunch;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final LauncherSubsystem m_launcherSubsystem = new LauncherSubsystem();

  private final SetSpeedLaunch m_setSpeedLaunch = new SetSpeedLaunch(m_launcherSubsystem);

  private final StopMotors m_stopMotors = new StopMotors(m_launcherSubsystem);

  private final VariableSpeedLaunch m_variableSpeedLaunch = new VariableSpeedLaunch(m_launcherSubsystem, ()-> getSliderAxis());

  private final T25B100Launch m_t25b100Launch = new T25B100Launch(m_launcherSubsystem);

  private final T50B100Launch m_t50b100Launch = new T50B100Launch(m_launcherSubsystem);

  private final T75B100Launch m_t75b100Launch = new T75B100Launch(m_launcherSubsystem);

  private final T100B75Launch m_t100b75Launch = new T100B75Launch(m_launcherSubsystem);

  private final T100B50Launch m_t100b50Launch = new T100B50Launch(m_launcherSubsystem);

  private final T100B25Launch m_t100b25Launch = new T100B25Launch(m_launcherSubsystem);

  private final DashboardSpeed m_dashboardSpeed = new DashboardSpeed(m_launcherSubsystem);

  private final Joystick joystick = new Joystick(0);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(joystick, 1).whileHeld(new DashboardSpeed(m_launcherSubsystem)); // Uses the speed of the throttle while the trigger is held
    new JoystickButton(joystick, 2).whileHeld(new SetSpeedLaunch(m_launcherSubsystem)); // Sets the launch speed while the thumb button is held
    new JoystickButton(joystick, 6).whileHeld(new SpinWheel(m_launcherSubsystem));
    new JoystickButton(joystick, Constants.T100B25Button).whileHeld(new T100B25Launch(m_launcherSubsystem));
    new JoystickButton(joystick, Constants.T100B50Button).whileHeld(new T100B50Launch(m_launcherSubsystem));
    new JoystickButton(joystick, Constants.T100B75Button).whileHeld(new T100B75Launch(m_launcherSubsystem));
    new JoystickButton(joystick, Constants.T25B100Button).whileHeld(new T25B100Launch(m_launcherSubsystem));
    new JoystickButton(joystick, Constants.T50B100Button).whileHeld(new T50B100Launch(m_launcherSubsystem));
    new JoystickButton(joystick, Constants.T75B100Button).whileHeld(new T75B100Launch(m_launcherSubsystem));

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_stopMotors;
  }

  public double getSliderAxis(){
    return joystick.getThrottle();
  }
}
