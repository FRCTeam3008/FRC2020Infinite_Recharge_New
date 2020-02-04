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
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Spinner_Position_To_Color;
import frc.robot.commands.Tank_Drive_Command;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Spinner_Subsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.Drive_Train_Subsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public static Drive_Train_Subsystem DriveTrain;
  public static Spinner_Subsystem spinner;


  static Joystick stick0;

  public Tank_Drive_Command driving;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    DriveTrain = new Drive_Train_Subsystem();
    spinner = new Spinner_Subsystem();
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
    stick0 = new Joystick(Constants.JoystickPort);
    DriveTrain.setDefaultCommand(new Tank_Drive_Command());

    final JoystickButton ButtonB = new JoystickButton(stick0, 2);

    ButtonB.whileHeld(new Spinner_Position_To_Color());
  }

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