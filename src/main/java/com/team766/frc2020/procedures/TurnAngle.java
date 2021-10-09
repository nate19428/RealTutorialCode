package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;
import com.team766.framework.Context;

public class TurnAngle extends Procedure{
	public void run(Context context){
		context.takeOwnership(Robot.drive); 
		Robot.drive.resetGyro();
		Robot.drive.setDrivePower(0.25,0);
		while (Robot.drive.getGyroAngle()>=-90){
			context.yield();
			if (Robot.drive.getGyroAngle()>=-45){
				Robot.drive.setDrivePower(0.25,0);
			} else if (Robot.drive.getGyroAngle()>=-84){
				Robot.drive.setDrivePower(0.1,0);
			} else if (Robot.drive.getGyroAngle()>=-90){
				Robot.drive.setDrivePower(0.01,0);
			}
		}
		Robot.drive.setDrivePower(0,0);
	}
}