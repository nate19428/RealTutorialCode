package com.team766.frc2020.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.RobotProvider;
import com.team766.hal.SpeedController;
import com.team766.hal.EncoderReader;
import com.team766.hal.GyroReader;
import com.team766.logging.Category;
import com.team766.framework.Context;

public class Drive extends Mechanism {
	private SpeedController m_leftMotor; //Java runs through the contstructor and all the variables not in functions
	private SpeedController m_rightMotor;
	private EncoderReader m_leftEncoder;
	private EncoderReader m_rightEncoder;
	private GyroReader m_gyro;

	public Drive() {
		m_leftMotor = RobotProvider.instance.getMotor("drive.leftMotor");
		m_rightMotor = RobotProvider.instance.getMotor("drive.rightMotor");
		m_leftEncoder = RobotProvider.instance.getEncoder("drive.leftEncoder");
		m_rightEncoder = RobotProvider.instance.getEncoder("drive.rightEncoder");
		m_gyro = RobotProvider.instance.getGyro("drive.gyro");
		loggerCategory = Category.DRIVE;
	}
	public void setDrivePower(double leftPower, double rightPower){
		checkContextOwnership(); // makes sure it takes over 
		m_leftMotor.set(leftPower);
		m_rightMotor.set(rightPower);
	}
	public void setArcadeDrivePower(double forward, double turn){
		double leftMotorPower = forward + turn;
		double rightMotorPower = forward - turn;
		setDrivePower(leftMotorPower, rightMotorPower);
	}
	public double getEncoderDistance(){
		checkContextOwnership();
		log("Left: "+m_leftEncoder.getDistance()+" Right: "+m_rightEncoder.getDistance());
		return((m_leftEncoder.getDistance()+m_rightEncoder.getDistance())/2);
	}
	public void resetEncoders(){
		checkContextOwnership();
		m_leftEncoder.reset();
		m_rightEncoder.reset();
	}
	public double getGyroAngle(){
		checkContextOwnership();
		log("Gryo "+ m_gyro.getAngle());
		return(m_gyro.getAngle());
	}
	public void resetGyro(){
		checkContextOwnership();
		m_gyro.reset();
	}
	public void turnAngle(double angle, Context context){
		checkContextOwnership();
		resetGyro();
		if (angle<0){
			while(getGyroAngle()>angle){
				if (getGyroAngle()-angle>=15){
					setDrivePower(0.25,0);
				} else if (getGyroAngle()-angle>=4){
					setDrivePower(0.1,0);
				} else if (getGyroAngle()-angle>=0){
					setDrivePower(0.01,0);
				}
				context.yield();
			}
		} else{
			while(getGyroAngle()<angle){
				if (angle-getGyroAngle()>=15){
					setDrivePower(0,0.25);
				} else if (angle-getGyroAngle()>=4){
					setDrivePower(0,0.1);
				} else if (angle-getGyroAngle()>=0){
					setDrivePower(0,0.01);
				}
				context.yield();
			}
		}
	}
	public void DriveDistance(double distance, Context context){
		checkContextOwnership();
		resetEncoders();
		while (getEncoderDistance() <= distance){
			if (distance-getEncoderDistance() >= 20){
				setDrivePower(0.25,0.25);
			} else if (distance-getEncoderDistance()>=7){
				setDrivePower(0.1,0.1);
			} else if (distance-getEncoderDistance()>=0){
				setDrivePower(0.01,0.01);
			}
			context.yield();
		}
	}
}