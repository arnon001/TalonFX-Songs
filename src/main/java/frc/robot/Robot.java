
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

// put the songs in deploy folder!!!!

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */


/*
Make sure that the ports of the TalonFX are updated, with Phoneix Tuner!!!, Really Important
*/
public class Robot extends TimedRobot {
  Orchestra orchestra;
  TalonFX[] motors = { new TalonFX(1), new TalonFX(2), new TalonFX(3), new TalonFX(4), new TalonFX(5), new TalonFX(6), new TalonFX(7), new TalonFX(8), new TalonFX(9), new TalonFX(13)};
  String[] songs = new String[] {"nGGYUd.chrp", "Magalovenia.chrp", "oops.chrp" /* Oops.chrp is Pornhub Music*/};

  Joystick left;
  int timetoplay = 60;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.s
   */
  @Override
  public void robotInit() {
    ArrayList<TalonFX> instruments = new ArrayList<TalonFX>();
    for(int i = 0; i < motors.length; i++) {
      instruments.add(motors[i]);
    }
    orchestra = new Orchestra(instruments);
    left = new Joystick(0);
    loadSong(0);
  }

  private void loadSong(int selection) {
    orchestra.loadMusic(songs[selection]);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    orchestra.play();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
