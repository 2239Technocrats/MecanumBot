/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class Test1 extends Subsystem {
  
  public WPI_TalonSRX testM;

  public Test1(){
    testM = new WPI_TalonSRX(5);
  }

  @Override
  public void initDefaultCommand() {
    
  }

  public WPI_TalonSRX getMotor(){
    return testM;
  }


}
