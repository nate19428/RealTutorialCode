package com.team766.frc2020.procedures;

import com.team766.framework.Context;
import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;

public class DoNothing extends Procedure {

	public void run(Context context) {
		context.takeOwnership(Robot.drive);
		Robot.drive.turnAngle(-60, context);
		Robot.drive.DriveDistance(70, context);
	}
	
}