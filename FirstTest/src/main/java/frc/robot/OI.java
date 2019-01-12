/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.utils.XboxTriggerButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick DriverStick = new Joystick(0);
	public static XboxController ManipulatorStick = new XboxController(1);
	
	public Button driverA;
	public Button driverB;
	public Button driverX;
	public Button driverY;
	public Button driverRB;
	public Button driverRT;
	public Button driverLB;
	public Button driverLT;
	public Button driverDpadUp;
	public Button driverDpadDown;
	public Button driverDpadRight;
	public Button driverDpadLeft;
	public Button driverStart;
	
	public Button manipulatorA;
	public Button manipulatorB;
	public Button manipulatorX;
	public Button manipulatorY;
	public Button manipulatorLB;
	public Button manipulatorRB;
	public XboxTriggerButton manipulatorLT;
	public XboxTriggerButton manipulatorRT;
	public Button manipulatorBack;
	
	
	public OI() {
		//DRIVER BUTTONS - Logitech Controller
		driverA = new JoystickButton(DriverStick, 2);
		driverB = new JoystickButton(DriverStick, 3);
		driverX = new JoystickButton(DriverStick, 1);
		driverY = new JoystickButton(DriverStick, 4);
		driverRB = new JoystickButton(DriverStick, 6); 
		driverRT = new JoystickButton(DriverStick, 8);
		driverLB = new JoystickButton(DriverStick, 5);
		driverLT = new JoystickButton(DriverStick, 7);
		driverDpadUp = new JoystickButton(DriverStick, 1);
		driverDpadDown= new JoystickButton(DriverStick, 1);
		driverDpadRight= new JoystickButton(DriverStick, 1);
		driverDpadLeft= new JoystickButton(DriverStick, 1);
		driverStart = new JoystickButton(DriverStick, 10);
		

		

		
		//MANIPULATOR BUTTONS - Xbox Controller
		manipulatorA = new JoystickButton(ManipulatorStick, 1);
		manipulatorX = new JoystickButton(ManipulatorStick, 3);
		manipulatorB = new JoystickButton(ManipulatorStick, 2);
		manipulatorY = new JoystickButton(ManipulatorStick, 4);
		manipulatorLB = new JoystickButton(ManipulatorStick, 5);
		manipulatorRB = new JoystickButton(ManipulatorStick, 6);
		manipulatorLT = new XboxTriggerButton(ManipulatorStick, 2);
		manipulatorRT = new XboxTriggerButton(ManipulatorStick, 3);
		manipulatorBack = new JoystickButton(ManipulatorStick, 7);
		

	}
	
}