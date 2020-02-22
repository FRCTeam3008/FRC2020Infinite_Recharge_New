/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;

// import for tank drive
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drive_Train_Subsystem extends SubsystemBase {
  private CANSparkMax motorR1, motorR2, motorL1, motorL2;

  public DifferentialDrive diffDrive;
  private SpeedControllerGroup leftMotor, rightMotor;
  
  // Create 6 motors for drivetrain
  public Drive_Train_Subsystem()
  {
    //declare motors
    motorR1 = new CANSparkMax(Constants.MotorR1ID, MotorType.kBrushless);
    motorR2 = new CANSparkMax(Constants.MotorR2ID, MotorType.kBrushless);  
    motorL1 = new CANSparkMax(Constants.MotorL1ID, MotorType.kBrushless);
    motorL2 = new CANSparkMax(Constants.MotorL2ID, MotorType.kBrushless);
    
    //create differential drive
    leftMotor = new SpeedControllerGroup(motorL1, motorL2);
    rightMotor = new SpeedControllerGroup(motorR2, motorR1);
    diffDrive = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void driveOff()
  {
    motorL1.set(0);
    motorL2.set(0);
    motorR2.set(0);
    motorR1.set(0);
  }

  public void tankDrive(double speedL, double speedR)
  {
    diffDrive.tankDrive(-speedL, -speedR);
  }
}