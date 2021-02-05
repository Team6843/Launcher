/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //CAN Adresses Here
    public static int topMotor = 10; // Launcher top motor, TalonSRX
    public static int bottomMotor = 11; // Launcher bottom motor, TalonSRX

    //Button Adresses Here
    public static int T25B100Button = 12;
    public static int T50B100Button = 11;
    public static int T75B100Button = 10;
    public static int T100B75Button = 9;
    public static int T100B50Button = 8;
    public static int T100B25Button = 7;
    
}
