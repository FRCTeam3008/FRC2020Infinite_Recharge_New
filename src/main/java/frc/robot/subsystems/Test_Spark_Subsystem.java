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

public class Test_Spark_Subsystem extends SubsystemBase {
  /**
   * Creates a new Test_Spark_Subsystem.
   */
  private final Spark spinnerSpark = new Spark(0);
  
  public Test_Spark_Subsystem() {
    
  }

  public void spinnerForward() {
    spinnerSpark.set(0.5);    
  }

  public void spinnerOff() {
    spinnerSpark.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //System.out.println("HELP ME!!!! -SUBSYSTEM");

  }
}
