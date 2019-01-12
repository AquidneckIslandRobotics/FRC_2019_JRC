/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX leftFront = new TalonSRX(RobotMap.LEFT_FRONT);
	public TalonSRX leftTop = new TalonSRX(RobotMap.LEFT_TOP);
	public TalonSRX leftBottom = new TalonSRX(RobotMap.LEFT_BOTTOM);	
;	public TalonSRX rightFront = new TalonSRX(RobotMap.RIGHT_FRONT);
	public TalonSRX rightTop = new TalonSRX(RobotMap.RIGHT_TOP);
	public TalonSRX rightBottom = new TalonSRX(RobotMap.RIGHT_BOTTOM);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
