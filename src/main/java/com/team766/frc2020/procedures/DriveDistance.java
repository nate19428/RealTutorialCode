package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;
import com.team766.framework.Context;

public class DriveDistance extends Procedure{
	public void run(Context context){
		context.takeOwnership(Robot.drive);
		Robot.drive.resetEncoders();
		Robot.drive.setDrivePower(0.25, 0.25);
		while (Robot.drive.getEncoderDistance() <= 60){
			context.yield();
			if (Robot.drive.getEncoderDistance() <= 40){
				Robot.drive.setDrivePower(0.25,0.25);
			} else if (Robot.drive.getEncoderDistance()<=51){
				Robot.drive.setDrivePower(0.1,0.1);
			} else if (Robot.drive.getEncoderDistance()<=60){
				Robot.drive.setDrivePower(0.01,0.01);
			}
		}
		Robot.drive.setDrivePower(0.0,0.0);
	}
}