package com.team766.frc2020;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.frc2020.Robot;
import com.team766.hal.JoystickReader;
import com.team766.hal.RobotProvider;
import com.team766.logging.Category;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the code that allow control of the robot.
 */
public class OI extends Procedure {
	private JoystickReader m_joystick0;
	private JoystickReader m_joystick1;
	private JoystickReader m_joystick2;
	
	public OI() {
		loggerCategory = Category.OPERATOR_INTERFACE;

		m_joystick0 = RobotProvider.instance.getJoystick(0);
		m_joystick1 = RobotProvider.instance.getJoystick(1);
		m_joystick2 = RobotProvider.instance.getJoystick(2);
	}
	
	public void run(Context context) {
		context.takeOwnership(Robot.drive); //declare this when first using this mechanism, only declare checkContextOwnership after declaring this
		context.takeOwnership(Robot.launcher);
		context.takeOwnership(Robot.intake);
		while (true) {
			log("J0 A0: " + m_joystick0.getAxis(0) +
			    "  J0 A1: " + m_joystick0.getAxis(1) +
			    "  J1 A0: " + m_joystick1.getAxis(0) +
			    "  J1 A1: " + m_joystick1.getAxis(1) +
			    "  J0 B1: " + m_joystick0.getButton(1) +
			    "  J0 B2: " + m_joystick0.getButton(2) +
			    "  J0 B3: " + m_joystick0.getButton(3));
			Robot.drive.setArcadeDrivePower(m_joystick1.getAxis(1), m_joystick1.getAxis(0));
			Robot.launcher.setPusher(m_joystick0.getButton(2));
			Robot.intake.setIntake(m_joystick0.getButton(1));
			while (RobotProvider.instance.hasNewDriverStationData() == false) {// Add driver controls here - make sure to take/release ownership
			// of mechanisms when appropriate.
			context.yield();
			//context.waitFor(() -> RobotProvider.instance.hasNewDriverStationData()); like a reepeat until block - repeats until RobotProvider = true
			}
		}// only one context can use CPU -evaluates stuff
	}//wait for seconds notes down the time it is at right now and waits for timerightnow + seconds inputed; wait for does a while loop thing
}
