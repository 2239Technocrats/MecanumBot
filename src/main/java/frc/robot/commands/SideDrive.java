package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class SideDrive extends Command{

    private boolean flipped;

    public SideDrive(){
        
    }

    @Override
    protected void execute(){
        if(Robot.drivetrain.isULTRASUPERMEGACOOLMODE()){
            Robot.drivetrain.setULTRASUPERMEGACOOLMODE(false);
        }
        else{
            Robot.drivetrain.setULTRASUPERMEGACOOLMODE(true);
        }
    }

    @Override 
    protected boolean isFinished(){
        return true;
    }
}