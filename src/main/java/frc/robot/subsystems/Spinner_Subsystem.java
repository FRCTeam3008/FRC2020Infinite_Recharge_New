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
  private CANSparkMax Spinner;
  public Spinner_Subsystem()
  {
    Spinner = new CANSparkMax(Constants.Spark13ID, MotorType.kBrushless);
  }

  public void spinnerOff()
  {
    Spinner.set(0.0);
  }

  public void spinnerTurn()
  {
    Spinner.set(1.0);
  }

  public void positionToColor()
  {
   
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
