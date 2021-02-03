package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class LauncherSubsystem extends SubsystemBase {
  /**
   * A subsystem containing everything for the launcher
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
    
  }

  public void setSpeed() {
    topMotor.set(ControlMode.PercentOutput, -0.90);
    bottomMotor.set(ControlMode.PercentOutput, -0.90);
  }

  public void variableSpeed(double speed) {
    double posSpeed = Math.sqrt(Math.pow(speed, 2));
    topMotor.set(ControlMode.PercentOutput, -posSpeed);
    bottomMotor.set(ControlMode.PercentOutput, -posSpeed);
  }

  public void stopMotors(){
    topMotor.set(ControlMode.PercentOutput, 0.0);
    bottomMotor.set(ControlMode.PercentOutput, 0.0);
  }


}
