package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

import java.io.Console;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import frc.robot.Robot;
/**
 * Accelerates motors
 */
public class TestMaxSpeed extends Command{

    private boolean finished = false;
    private WPI_TalonSRX[] testMs;
    private Timer timer = new Timer();
    private double time;
    private double speed;
    public double i;
    public double f;

    /**
     * 
     * @param motors array of motors
     * @param speed top speed
     * @param time time to reach top speed
     */
    public TestMaxSpeed(double speed,  double time){
        requires(Robot.test1);
        this.time = time;
        this.speed = speed;
    }

    @Override 
    protected void initialize(){
        finished = false;
        timer.start();
    }

    @Override
    protected void execute(){
        System.out.println(timer.get());
        if(timer.get() < 1+time &&  timer.get() > 1){
            System.out.println("Condition 1*******************************************************");
            Robot.test1.testM.set(ControlMode.PercentOutput, speed);
        }
        else if(timer.get() <= 1 && timer.get() > .9){
            Robot.test1.testM.set(ControlMode.PercentOutput, speed);
            System.out.println("Condition 2-------------------------------------------------------");
            i = Robot.test1.testM.getSelectedSensorPosition(0);
        }
        else if(timer.get() >= 1+time){
            f = Robot.test1.testM.getSelectedSensorPosition(0);
            System.out.println("Encoder Value:" +f);
            finished = true;
            System.out.println(f-i);
            System.out.print("!!!!!!!!!!!!");
        }
        
        
    }
    
    @Override 
    protected boolean isFinished(){
        return finished;
    }

    @Override
    protected void end(){
        timer.reset();
    }
}