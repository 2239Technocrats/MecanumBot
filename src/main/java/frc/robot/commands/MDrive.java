
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import frc.robot.subsystems.Facing;

/**
 * An example command.  You can replace me with your own command.
 */
public class MDrive extends Command {
    MecanumDrive drive;
    XboxController controller;
    Joystick joystick;
    public double speed = Robot.drivetrain.speed;
    public MDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        drive = Robot.drivetrain.getDrive();
        controller = Robot.oi.getXboxController();
        joystick = Robot.oi.getJoystick();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        speed = Robot.drivetrain.speed;
        System.out.println(Robot.drivetrain.direction);
        System.out.println("execute(); on tankdrive");
        switch (Robot.drivetrain.getDirection()) {
            case Forward:
                drive.driveCartesian(speed*controller.getRawAxis(1), -speed*controller.getRawAxis(0), .6*-speed*controller.getRawAxis(4));
                break;
            case Right:
            drive.driveCartesian(speed*controller.getRawAxis(0), speed*controller.getRawAxis(1), .6*speed*controller.getRawAxis(4));
                break;
            case Backward:
                drive.driveCartesian(-speed*controller.getRawAxis(1), speed*controller.getRawAxis(0), .6*speed*controller.getRawAxis(4));
                break;
            case Left:
                drive.driveCartesian(-speed*controller.getRawAxis(0), -speed*controller.getRawAxis(1), .6*speed*controller.getRawAxis(4));
                break;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        // System.out.println("isFinished(); on exampleCommand")
        return false;
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
