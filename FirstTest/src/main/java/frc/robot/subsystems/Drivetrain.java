/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX leftLeader = new TalonSRX(RobotMap.LEFT_FRONT);  //Front Motor
	public TalonSRX leftTop = new TalonSRX(RobotMap.LEFT_TOP);
	public TalonSRX leftBottom = new TalonSRX(RobotMap.LEFT_BOTTOM);	
	public TalonSRX rightLeader = new TalonSRX(RobotMap.RIGHT_FRONT);  //Front Motor
	public TalonSRX rightTop = new TalonSRX(RobotMap.RIGHT_TOP);
  public TalonSRX rightBottom = new TalonSRX(RobotMap.RIGHT_BOTTOM);

  int timeoutMs = 5000;
  double secondsFromNeutralToFull = 0.25;
  double leftSpeed, rightSpeed;
  
  public void chassisInit() {
		
		leftTop.follow(leftLeader);
		leftBottom.follow(leftLeader);
		
		rightTop.follow(rightLeader);
		rightBottom.follow(rightLeader);
		
		leftLeader.setInverted(true);
		leftTop.setInverted(true);
		leftBottom.setInverted(true);
		rightLeader.setInverted(true);
		rightTop.setInverted(true);
		rightBottom.setInverted(true);
		

		leftLeader.configOpenloopRamp( secondsFromNeutralToFull, timeoutMs);
		leftTop.configOpenloopRamp(secondsFromNeutralToFull, timeoutMs);
		leftBottom.configOpenloopRamp(secondsFromNeutralToFull, timeoutMs);
		rightLeader.configOpenloopRamp(secondsFromNeutralToFull, timeoutMs);
		rightTop.configOpenloopRamp(secondsFromNeutralToFull, timeoutMs);
		rightBottom.configOpenloopRamp(secondsFromNeutralToFull, timeoutMs);
		
		leftLeader.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rightLeader.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rightLeader.setSensorPhase(true);
		
		rightLeader.setIntegralAccumulator(20, 0, 10);
		rightLeader.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 10);
		rightLeader.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
		rightLeader.configNominalOutputForward(0, 10);
		rightLeader.configNominalOutputReverse(0, 10);
		rightLeader.configPeakOutputForward(1, 10);
		rightLeader.configPeakOutputReverse(-1, 10);
		rightLeader.selectProfileSlot(1, 1);
		rightLeader.config_kF(0, 0.20, 10); //.21 - .19
		rightLeader.config_kP(0, 0.505, 10); //.57 - .455
		rightLeader.config_kI(0, 0.0, 10);//.005 - .001
		rightLeader.config_kD(0, 0, 10);   //.42 - 20
		rightLeader.configMotionCruiseVelocity(3653, 10);
		rightLeader.configMotionAcceleration(3653, 10);
		rightLeader.setSelectedSensorPosition(0, 0, 10);
		
		leftLeader.setIntegralAccumulator(19, 0, 10);
		leftLeader.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 10);
		leftLeader.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 10);
		leftLeader.configNominalOutputForward(0, 10);
		leftLeader.configNominalOutputReverse(0, 10);
		leftLeader.configPeakOutputForward(1, 10);
		leftLeader.configPeakOutputReverse(-1, 10);
		leftLeader.selectProfileSlot(0, 0);
		leftLeader.config_kF(0, 0.20, 10); //.22 - .2199
		leftLeader.config_kP(0, 0.505, 10);  //.6 - .515
		leftLeader.config_kI(0, 0.0, 10); //.02 - .003
		leftLeader.config_kD(0, 0, 10);   //40 - 19
		leftLeader.configMotionCruiseVelocity(3653, 10);
		leftLeader.configMotionAcceleration(3653, 10);
		leftLeader.setSelectedSensorPosition(0, 0, 10);
		
	}

  @Override
  public void initDefaultCommand() {
  setDefaultCommand(new DriveWithJoysticks());
  }
  
  public void driveWithJoysticks() {
    if(Math.abs(OI.DriverStick.getY()) < RobotMap.STICK_DEADZONE) leftSpeed = 0;
    else leftSpeed = -OI.DriverStick.getY();
    if(Math.abs(OI.DriverStick.getThrottle()) < RobotMap.STICK_DEADZONE) rightSpeed = 0;
    else rightSpeed = OI.DriverStick.getThrottle();
    setSpeed(leftSpeed, rightSpeed);
  }
  public void setSpeed(double left, double right) {
    leftLeader.set(ControlMode.PercentOutput, left);
    rightLeader.set(ControlMode.PercentOutput, right);
  }
}
