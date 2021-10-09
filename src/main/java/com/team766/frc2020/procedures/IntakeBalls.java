package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;
import com.team766.framework.Context;

public class IntakeBalls extends Procedure{
	DriveStraight driveStraight = new DriveStraight();
	public void run(Context context){
		context.takeOwnership(Robot.intake);
		Robot.intake.StartIntake();
		driveStraight.run(context);
		Robot.intake.StopIntake();
	}
}