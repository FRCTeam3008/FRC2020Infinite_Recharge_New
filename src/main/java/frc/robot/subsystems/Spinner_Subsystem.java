/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.*;

//COLOR SENSOR
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class Spinner_Subsystem extends SubsystemBase {
  private final CANSparkMax spinnerSparkMax;
  public String colorString;
  public String updatedColor;
  public int colorInteger;

  public Spinner_Subsystem() {
    spinnerSparkMax = new CANSparkMax(5, MotorType.kBrushed); //change deviceID
  }
  /**
   * Creates a new Spinner_Subsystem.
   */

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 testColorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch colorMatcher = new ColorMatch();

  // Adjust as needed! (numbers on side were default)
  private final Color kBlueTarget = ColorMatch.makeColor(0.19, 0.45, 0.33); //0.143, 0.427, 0.429
  private final Color kGreenTarget = ColorMatch.makeColor(0.22, 0.54, 0.25); //0.197, 0.561, 0.24
  private final Color kRedTarget = ColorMatch.makeColor(0.41, 0.40, 0.18); //0.561, 0.232, 0.114
  private final Color kYellowTarget = ColorMatch.makeColor(0.32, 0.524, 0.14); //0.361, 0.524, 0.113

  public void storeColor() {
    updatedColor = colorString;
    colorInteger = 0;
  }
  
  public void spinnerIncrement()
  {
    if (updatedColor == colorString) {
      spinnerSparkMax.set(0.5);
    } else {
      spinnerSparkMax.set(0);
    }
  }

  public void spinnerHalfRotation() {
    if (updatedColor != colorString) {
      colorInteger++;
      updatedColor = colorString;
    } 
    if (colorInteger < 4) {
      spinnerSparkMax.set(0.5);
    } else {
      spinnerSparkMax.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    colorMatcher.addColorMatch(kBlueTarget);
    colorMatcher.addColorMatch(kGreenTarget);
    colorMatcher.addColorMatch(kRedTarget);
    colorMatcher.addColorMatch(kYellowTarget);
    
    Color detectedColor = testColorSensor.getColor();
    double IR = testColorSensor.getIR();

    //to check values detected by color sensor
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);

    int proximity = testColorSensor.getProximity();
    SmartDashboard.putNumber("Proximity", proximity);
    
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
  }
}
