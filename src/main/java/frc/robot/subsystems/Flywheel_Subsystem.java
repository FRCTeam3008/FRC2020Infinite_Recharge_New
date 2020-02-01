/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Flywheel_Subsystem extends SubsystemBase {
  /**
   * Creates a new Flywheel_Subsystem.
   */
  private CANSparkMax Flywheel;
  public Flywheel_Subsystem() 
  {
    Flywheel = new CANSparkMax(Constants.Spark6ID, MotorType.kBrushless);
  }

  public void flywheelOn()
  {
    Flywheel.set(1.0);
  }

  public void flywheelOff()
  {
    Flywheel.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
