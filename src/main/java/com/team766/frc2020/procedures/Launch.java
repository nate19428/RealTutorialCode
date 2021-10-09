package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;
import com.team766.framework.Context;

public class Launch extends Procedure {
	
	public void run(Context context){
		context.takeOwnership(Robot.launcher);
		Robot.launcher.setPusher(true);
		context.waitForSeconds(0.25);
		Robot.launcher.setPusher(false);
	}
}