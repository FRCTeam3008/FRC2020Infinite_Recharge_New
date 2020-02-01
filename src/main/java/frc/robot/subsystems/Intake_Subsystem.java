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

public class Intake_Subsystem extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  private CANSparkMax IntakeR;
  private CANSparkMax IntakeL;
   public Intake_Subsystem() 
  {
    IntakeL = new CANSparkMax(Constants.Spark7ID, MotorType.kBrushless);
    IntakeR = new CANSparkMax(Constants.Spark8ID, MotorType.kBrushless);

  }

  public void intakeOff()
  {
    IntakeL.set(0.0);
    IntakeR.set(0.0);
  }

  public void intakeOn()
  {
    IntakeL.set(1.0);
    IntakeR.set(1.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
