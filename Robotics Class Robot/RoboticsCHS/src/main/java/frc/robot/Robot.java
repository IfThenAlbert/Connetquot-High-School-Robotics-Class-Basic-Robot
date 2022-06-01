// Developer Name: ALBERT ANG
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;


public class Robot extends TimedRobot {

  // this creates instance of DifferentialDrive which creates the driving functionality of the robot
  DifferentialDrive TheRobot;

  // controller for driver
  Joystick driverControl;

  @Override
  public void robotInit() {

    // set the controller listener to Driver Station INDEX 0 (the very first controller FRC Driver Station Sees)
    driverControl = new Joystick(0);

    // assign PWM TALONSRX motors with its PWM PIN
    PWMTalonSRX motorOne = new PWMTalonSRX(1);
    PWMTalonSRX motorTwo = new PWMTalonSRX(2);
    PWMTalonSRX motorThree = new PWMTalonSRX(3);
    PWMTalonSRX motorFour = new PWMTalonSRX(4); 
    
    // sets the motors for the robot to use in drive
    MotorControllerGroup leftSide = new MotorControllerGroup(motorOne, motorTwo);
    MotorControllerGroup rightSide = new MotorControllerGroup(motorThree, motorFour);   
    TheRobot = new DifferentialDrive(leftSide, rightSide);

  }

  @Override
  public void teleopPeriodic() {

    // controll the drive of the robot;
    TheRobot.arcadeDrive( (driverControl.getY() * -1) *.70 ,(driverControl.getX() * -1)  *.70);
    
    
  }


};

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */