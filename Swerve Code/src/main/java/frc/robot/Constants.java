// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final class DriveConstants {
      // Driving Parameters - Note that these are not the maximum capable speeds of
      // the robot, rather the allowed maximum speeds
      public static final double kMaxSpeedMetersPerSecond = 6.9
      ;
      public static final double kMaxAngularSpeed = 2 * Math.PI; // radians per second
  
      public static final double kDirectionSlewRate = 1.2; // radians per second
      public static final double kMagnitudeSlewRate = 1.8; // percent per second (1 = 100%)
      public static final double kRotationalSlewRate = 2.0; // percent per second (1 = 100%)
  
      public static final double kDriveWidth = 26.5;
  
      // Chassis configuration
      public static final double kTrackWidth = Units.inchesToMeters(kDriveWidth);
      // Distance between centers of right and left wheels on robot
      public static final double kWheelBase = Units.inchesToMeters(kDriveWidth);
      // Distance between front and back wheels on robot
      public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
          new Translation2d(kWheelBase / 2, kTrackWidth / 2),
          new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
          new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
          new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));
  
      // Angular offsets of the modules relative to the chassis in radians
      public static final double kFrontLeftChassisAngularOffset = -Math.PI / 2;
      public static final double kFrontRightChassisAngularOffset = 0;
      public static final double kBackLeftChassisAngularOffset = Math.PI;
      public static final double kBackRightChassisAngularOffset = Math.PI / 2;
  
      // SPARK MAX CAN IDs
      public static final int kFrontLeftDrivingCanId = 11;
      public static final int kRearLeftDrivingCanId = 13;
      public static final int kFrontRightDrivingCanId = 15;
      public static final int kRearRightDrivingCanId = 17;
  
      public static final int kFrontLeftTurningCanId = 32;
      public static final int kRearLeftTurningCanId = 16;
      public static final int kFrontRightTurningCanId = 14;
      public static final int kRearRightTurningCanId = 12;
  
      public static final boolean kGyroReversed = false;
    }
  
    public static final class ModuleConstants {
      // The MAXSwerve module can be configured with one of three pinion gears: 12T,
      // 13T, or 14T.
      // This changes the drive speed of the module (a pinion gear with more teeth
      // will result in a
      // robot that drives faster).
      public static final int kDrivingMotorPinionTeeth = 14;
  
      // Invert the turning encoder, since the output shaft rotates in the opposite
      // direction of
      // the steering motor in the MAXSwerve Module.
      public static final boolean kTurningEncoderInverted = true;
  
      // Calculations required for driving motor conversion factors and feed forward
      public static final double kDrivingMotorFreeSpeedRps = 6000 / 60;
      public static final double kWheelDiameterMeters = 0.0762;
      public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
      // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15
      // teeth on the bevel pinion
      public static final double kDrivingMotorReduction = 3.56;
      public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
          / kDrivingMotorReduction;
  
      public static final double kDrivingEncoderPositionFactor = (kWheelCircumferenceMeters)
          / kDrivingMotorReduction; // meters
      public static final double kDrivingEncoderVelocityFactor = ((kWheelCircumferenceMeters)
          / kDrivingMotorReduction); // meters per second
  
      public static final double kTurningEncoderPositionFactor = (2 * Math.PI); // radians
      public static final double kTurningEncoderVelocityFactor = (2 * Math.PI) / 60.0; // radians per second
  
      public static final double kTurningEncoderPositionPIDMinInput = 0; // radians
      public static final double kTurningEncoderPositionPIDMaxInput = kTurningEncoderPositionFactor; // radians
  
      public static final double kDrivingP = 0.33;
      public static final double kDrivingI = 0.0;
      public static final double kDrivingD = 0.004;
      public static final double kDrivingFF = 0;
      public static final double kDrivingMinOutput = -1;
      public static final double kDrivingMaxOutput = 1;
  
      public static final double kTurningP = 0.5;
      public static final double kTurningI = 0;
      public static final double kTurningD = 0.001;
      public static final double kTurningFF = 0;
      public static final double kTurningMinOutput = -1;
      public static final double kTurningMaxOutput = 1;
  
      public static final IdleMode kDrivingMotorIdleMode = IdleMode.kBrake;
      public static final IdleMode kTurningMotorIdleMode = IdleMode.kBrake;
  
      public static final int kDrivingMotorCurrentLimit = 80; // amps
      public static final int kTurningMotorCurrentLimit = 20; // amps
    }

    public static final class OIConstants {
      public static final int kDriverControllerPort = 0;
      public static final int kAuxControllerPort = 1;
      public static final double kDriveDeadband = 0.1;
    }
  
    public static final class AutoConstants {
      public static final double kSwerveDiscreteTimestep = 0.02;
      public static final double kSwerveDriveRadiusMeters = Units.inchesToMeters(DriveConstants.kDriveWidth) / 2;
      public static final PIDConstants kTranslationPIDConstants = new PIDConstants(5.0, 0.0, 0.0);
      public static final PIDConstants kRotationPIDConstants = new PIDConstants(5.0, 0.0, 0.0);
    }
  
    public static final class NeoMotorConstants {
      public static final double kFreeSpeedRpm = 5676;
    }
  }
}
  