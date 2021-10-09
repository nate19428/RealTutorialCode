package com.team766.frc2020.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.PositionReader;
import com.team766.hal.RobotProvider;
import com.team766.frc2020.Robot;

public class RobotPosition extends Mechanism {
    private PositionReader m_positionSensor = RobotProvider.instance.getPositionSensor();

	public double getX(){
		return m_positionSensor.getX();
	}

	public double getY(){
		return m_positionSensor.getY();
	}

	public double getHeading(){
		return m_positionSensor.getHeading(); //ask how to reset this
	}
    @Override
    public void run() {
        log("Robot position %f %f %f", m_positionSensor.getX(), m_positionSensor.getY(), m_positionSensor.getHeading());
	}
}
