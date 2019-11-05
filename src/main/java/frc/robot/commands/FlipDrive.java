package frc.robot.commands;

import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain.*;
import frc.robot.subsystems.Facing;

public class FlipDrive extends Command {

    private boolean flipped;

    public FlipDrive() {
        
    }

    @Override
    protected void execute(){
        switch (Robot.drivetrain.getDirection()) {
            case Forward:
                Robot.drivetrain.setDirection(Facing.Right);
                break;
            case Right:
                Robot.drivetrain.setDirection(Facing.Backward);
                break;
            case Backward:
                Robot.drivetrain.setDirection(Facing.Left);
                break;
            case Left:
                Robot.drivetrain.setDirection(Facing.Forward);
                break;
        }
    }

    @Override 
    protected boolean isFinished() {
        return true;
    }
}