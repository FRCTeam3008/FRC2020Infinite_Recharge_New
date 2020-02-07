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


public class Hook_Subsystem extends SubsystemBase {
  /**
   * Creates a new Hook_Subsystem.
   */
  private CANSparkMax HookR;
  private CANSparkMax HookL;

  public Hook_Subsystem() 
  {
    HookL = new CANSparkMax(Constants.Spark11ID, MotorType.kBrushless);
    HookR = new CANSparkMax(Constants.Spark12ID, MotorType.kBrushless);

  }


  public void hookRelease()
  {
  }

  public void winchForward()
  {
  }

  public void winchOff()
  {
    HookL.set(0.0);
    HookR.set(0.0);
  }

  public void winchReverse()
  {
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
