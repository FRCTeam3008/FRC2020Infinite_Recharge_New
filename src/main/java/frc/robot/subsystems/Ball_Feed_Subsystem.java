/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;

public class Ball_Feed_Subsystem extends SubsystemBase {
  /**
   * Creates a new Ball_Feed_Subsystem.
   */
  private Spark ballFeedSpark;

  public Ball_Feed_Subsystem() {
    ballFeedSpark = new Spark(Constants.BallFeedSpark);
  }

  public void ballFeedOn()
  {
    ballFeedSpark.set(-.5);
  }

  public void ballFeedOff()
  {
    ballFeedSpark.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
