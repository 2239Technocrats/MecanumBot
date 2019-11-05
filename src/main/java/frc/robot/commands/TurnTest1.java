/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Robot;

public class TurnTest1 extends Command {

  public WPI_TalonSRX motor;
  public double setPoint;

  public TurnTest1(double setPoint) {
    requires(Robot.test1);
    this.setPoint = setPoint;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    motor = Robot.test1.getMotor();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    motor.set(ControlMode.MotionMagic, setPoint);
    System.out.println("execute("+setPoint+"); on TurnTest1");
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
