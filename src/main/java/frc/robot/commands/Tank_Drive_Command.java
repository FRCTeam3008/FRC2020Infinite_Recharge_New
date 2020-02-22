package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Tank_Drive_Command extends CommandBase {
  /**
   * Creates a new Tank_Drive_Command.
   */
  public double stickL, stickR;
  
  public Tank_Drive_Command() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.DriveTrain);
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    stickL = RobotContainer.getLeftStickY();
    stickR = RobotContainer.getRightStickY();
    RobotContainer.DriveTrain.tankDrive(stickL, stickR);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}