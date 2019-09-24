package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import frc.robot.Robot;

public class SpeedSet extends Command{

    private boolean finished = false;
    private WPI_TalonSRX[] testMs;
    private Timer timer = new Timer();
    private double speed;

    public SpeedSet(WPI_TalonSRX[] motors, double speed){
        requires(Robot.test1);
        timer.reset();
        testMs = motors;
        this.speed = speed;
        timer.start();
    }

    @Override
    protected void execute(){
        for(WPI_TalonSRX arg : testMs){
            arg.set(ControlMode.PercentOutput, speed);
        }
    }

    @Override 
    protected boolean isFinished(){
        return true;
    }
}