/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Spark;

public class Winch_Subsystem extends SubsystemBase {
  /**
   * Creates a new Hook_Subsystem.s
   */
  private Spark winchSpark;
  

  public Winch_Subsystem() 
  {
    winchSpark = new Spark(Constants.WinchSpark);

  }

  public void winchOut()
  {
    winchSpark.set(1.0);
  }

  public void winchIn()
  {
    winchSpark.set(-1.0);
  }

  public void winchOff()
  {
    winchSpark.set(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
