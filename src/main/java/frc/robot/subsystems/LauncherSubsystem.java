package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class LauncherSubsystem extends SubsystemBase {
  /**
   * A subsystem containing everything for the launcher
   * 
   * @author JSamson
   */

  private final WPI_TalonSRX topMotor = new WPI_TalonSRX(Constants.topMotor);
  private final WPI_TalonSRX bottomMotor = new WPI_TalonSRX(Constants.bottomMotor);


  public LauncherSubsystem() {


    topMotor.set(ControlMode.PercentOutput, 0.0);
    bottomMotor.set(ControlMode.PercentOutput, 0.0);
    // Sets the ramp to 0 and control mode to brake, so the motors stop when we say
    topMotor.configOpenloopRamp(0);
    bottomMotor.configOpenloopRamp(0);
    topMotor.setNeutralMode(NeutralMode.Coast);
    bottomMotor.setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void periodic() { // This method will be called once per scheduler run
    SmartDashboard.putNumber("Bottom Motor Speed Percentage", 50);
    SmartDashboard.putNumber("Top Motor Speed Percentage", 50);

    
  }

/**
 * Sets the speed of the motors to the values inputted in the SmartDashboard
 */
  public void dashboardSpeed(){
    topMotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber("Top Motor Speed Percentage", 50)/100.0);
    bottomMotor.set(ControlMode.PercentOutput, SmartDashboard.getNumber("Bottom Motor Speed Percentage", 50)/100.0);
  }

  /**
   * Sets the speed of the motors to 90%
   */
  public void setSpeed() {
    topMotor.set(ControlMode.PercentOutput, 0.90);
    bottomMotor.set(ControlMode.PercentOutput, -0.90);
  }
/**
 * Sets the motor speed to whatever speed is passed in
 * @param speed the speed for the motors to be set at
 */
  public void variableSpeed(double speed) {
    double posSpeed = Math.sqrt(Math.pow(speed, 2));
    topMotor.set(ControlMode.PercentOutput, posSpeed);
    bottomMotor.set(ControlMode.PercentOutput, -posSpeed);
  }

  /**
   * Sets the motors to whatever speed is passed in for each one
   * @param topSpeed the speed for the top motor
   * @param bottomSpeed the speed for the bottom motor
   */
  public void setSeparateSpeeds(double topSpeed, double bottomSpeed){
    topMotor.set(ControlMode.PercentOutput, topSpeed);
    bottomMotor.set(ControlMode.PercentOutput, -bottomSpeed);
  }

  /**
   * Stops the launcher motors
   */
  public void stopMotors(){
    topMotor.set(ControlMode.PercentOutput, 0.0);
    bottomMotor.set(ControlMode.PercentOutput, 0.0);
    topMotor.stopMotor();
    bottomMotor.stopMotor();
  }


}
