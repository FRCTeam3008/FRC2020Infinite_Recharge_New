/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Ball_Feed_Off;
import frc.robot.commands.Ball_Feed_On;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Flywheel_On;
import frc.robot.commands.Intake_CommandGroup;
import frc.robot.commands.Spinner_Half_Rotation;
import frc.robot.commands.Spinner_Position_To_Color;
import frc.robot.commands.Mec_Arm_On;
import frc.robot.commands.Shoot_CommandGroup;
import frc.robot.commands.Winch_In;
import frc.robot.commands.Winch_Out;
import frc.robot.commands.Tank_Drive_Command;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//SUBSYSTEM
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //public static final String Hook = null;
// The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public static Drive_Train_Subsystem DriveTrain;
  public static Flywheel_Subsystem Flywheel;
  public static Winch_Subsystem Winch;
  public static Mec_Arm_Subsystem MecArm;
  public static Spinner_Subsystem Spinner;
  public static Ball_Feed_Subsystem BallFeed;
  

  static Joystick stick0;

  public Tank_Drive_Command driving;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    DriveTrain = new Drive_Train_Subsystem();
    Spinner = new Spinner_Subsystem();
    Winch = new Winch_Subsystem();
    Flywheel = new Flywheel_Subsystem();
    MecArm = new Mec_Arm_Subsystem();
    BallFeed = new Ball_Feed_Subsystem();

    // Configure the button bindings
    configureButtonBindings();
    
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // joystick and button decleration
    stick0 = new Joystick(Constants.JoystickPort);

    final JoystickButton ButtonA = new JoystickButton(stick0, Constants.ButtonA);
    final JoystickButton ButtonB = new JoystickButton(stick0, Constants.ButtonB);
    final JoystickButton ButtonX = new JoystickButton(stick0, Constants.ButtonX);
    final JoystickButton ButtonY = new JoystickButton(stick0, Constants.ButtonY);

    final JoystickButton RBumper = new JoystickButton(stick0, Constants.RBumper);
    final JoystickButton LBumper = new JoystickButton(stick0, Constants.LBumper);

    //LBumper.whileHeld(new Ball_Feed_On());
    LBumper.whileHeld(new Intake_CommandGroup());
    RBumper.whileHeld(new Shoot_CommandGroup());
    ButtonX.whileHeld(new Winch_In());
    ButtonY.whileHeld(new Winch_Out());

    // set default commands
    DriveTrain.setDefaultCommand(new Tank_Drive_Command());
  }

  // get joystick axis numbers
  public static double getLeftStickY()
  {
    return (stick0.getRawAxis(Constants.LeftJoystickID));
  }

  public static double getRightStickY()
  {
    return (stick0.getRawAxis(Constants.RightJoystickID));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public Command getDriving()
  {
    return driving;
  }
}