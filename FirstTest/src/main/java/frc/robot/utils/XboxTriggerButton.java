/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.RobotMap;

public class XboxTriggerButton extends Button {
	
	XboxController m_joystick;
	int m_axis;
	
	public XboxTriggerButton(XboxController manipulatorStick, int axis) {
		m_joystick = manipulatorStick;
		m_axis = axis;
	}
	
	public boolean get() {
		if(Math.abs(m_joystick.getRawAxis(m_axis)) < RobotMap.STICK_DEADZONE) return false;
		else return true;
	}
	
}
