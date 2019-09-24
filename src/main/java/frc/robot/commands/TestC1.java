package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import frc.robot.Robot;

public class TestC1 extends CommandGroup{
    private double speed = Robot.drivetrain.speed;
    private WPI_TalonSRX[] testM = {Robot.test1.getMotor()};
    double releaseTiming;

    
    public TestC1(JoystickButton button, double time){
        addSequential(new AccelMotors(testM, speed, time));
        addSequential(new SpeedSet(testM, speed));
        addSequential(new DecelMotors(testM, speed, time));
    }

}