package com.team766.frc2020.mechanisms;

import com.team766.hal.SolenoidController;
import com.team766.framework.Mechanism;
import com.team766.hal.RobotProvider;
import com.team766.hal.SpeedController;

public class Intake extends Mechanism{
	SolenoidController m_intakeArm;
	SpeedController m_intakeWheels;
	public Intake() {
		m_intakeArm = RobotProvider.instance.getSolenoid("intakeArm");
		m_intakeWheels = RobotProvider.instance.getMotor("intakeWheels");
	}

	public void StartIntake() {
		m_intakeArm.set(true);
		m_intakeWheels.set(1.0);
	}
	
	public void StopIntake() {
		m_intakeArm.set(false);
		m_intakeWheels.set(0.0);
	}

	public void setIntake(boolean a){
		if (a == true){
			StartIntake();
		} else{
			StopIntake();
		}
	}
}