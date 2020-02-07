/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Spinner_Subsystem extends SubsystemBase {
  /**
   * Creates a new Spinner_Subsystem.
   */
  private final CANSparkMax spinnerSparkMax;
  public Spinner_Subsystem()
  {
    spinnerSparkMax = new CANSparkMax(Constants.Spark13ID, MotorType.kBrushless);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
