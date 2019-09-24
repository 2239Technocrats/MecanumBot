package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import frc.robot.Robot;

public class DecelMotors extends Command{

    private boolean finished = false;
    private WPI_TalonSRX[] testMs;
    private Timer timer = new Timer();
    private double time;
    private double speed;

    public DecelMotors(WPI_TalonSRX[] motors, double speed, double time){
        requires(Robot.test1);
        timer.reset();
        testMs = motors;
        this.speed = speed;
        this.time = time;
        timer.start();
    }

    @Override
    protected void execute() {
        if(timer.get() < 1.0) {
            for(WPI_TalonSRX arg : testMs) {
                arg.set(ControlMode.PercentOutput, speed*(timer.get()/time));
            }
        }
        finished = true;
    }

    @Override 
    protected boolean isFinished(){
        return finished;
    }
}