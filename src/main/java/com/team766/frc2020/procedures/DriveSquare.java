package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;
import com.team766.framework.Context;
import com.team766.logging.Category;

public class DriveSquare extends Procedure {
	DriveDistance DriveDistance = new DriveDistance(); //Can declare here because we are creating this variable
	TurnAngle TurnAngle = new TurnAngle();
	public DriveSquare(){
		loggerCategory = Category.AUTONOMOUS; //Delcare here since we aren't creating it, just changing its value
	}

	public void run(Context context){ //Contexts allow procedures to run at the same time, each under a different context (2 contexts in one function useless as it goes in the function order)
		context.takeOwnership(Robot.drive);
		for (int i=1;i<5;++i){
		DriveDistance.run(context);
		log(i+" side complete");
		TurnAngle.run(context);
		log(i+" corner complete");
		}
	}
}