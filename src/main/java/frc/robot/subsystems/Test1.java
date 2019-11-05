/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DefaultTest1;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

/*
 * Add your docs here.
 */

public class Test1 extends Subsystem {
  public WPI_TalonSRX testM;
  public final int MAX_OBSERVE = 13180;
  public final double MINUTES_PER_100MS = 1/600;
  public final int TICKS_PER_REVOLUTION = 1024;
  public double ticksPer100ms = MAX_OBSERVE*MINUTES_PER_100MS*TICKS_PER_REVOLUTION;

  public int timeoutMs = 30;
  public int PIDFloopID = 0;

  public final double F = ticksPer100ms;
  public final double P = .00001;
  public final double I = 0;
  public final double D = 0;


  public Test1(){
    testM = new WPI_TalonSRX(5);
    testM.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, PIDFloopID, timeoutMs);
    testM.configMotionCruiseVelocity((int)(.75*ticksPer100ms), timeoutMs);
    testM.configMotionAcceleration((int)(3*ticksPer100ms), timeoutMs);
    testM.selectProfileSlot(0, PIDFloopID);
  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new DefaultTest1());
  }

  public WPI_TalonSRX getMotor(){
    return testM;
  }

  

}
