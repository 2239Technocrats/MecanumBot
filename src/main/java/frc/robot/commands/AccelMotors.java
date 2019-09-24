package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import frc.robot.Robot;
/**
 * Accelerates motors
 */
public class AccelMotors extends Command{

    private boolean finished = false;
    private WPI_TalonSRX[] testMs;
    private Timer timer = new Timer();
    private double time;
    private double speed;

    /**
     * 
     * @param motors array of motors
     * @param speed top speed
     * @param time time to reach top speed
     */
    public AccelMotors(WPI_TalonSRX[] motors, double speed,  double time){
        requires(Robot.test1);
        testMs = motors;
        this.time = time;
        this.speed = speed;
        timer.start();
    }
    @Override
    protected void execute(){
        if(timer.get() < time){
            for(WPI_TalonSRX arg : testMs){
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