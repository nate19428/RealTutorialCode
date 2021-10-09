package com.team766.frc2020.procedures;
 
import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.frc2020.Robot;
import com.team766.logging.Category;


public class GoToPoint extends Procedure{
	public GoToPoint(){
		loggerCategory = Category.AUTONOMOUS;
	}

	public void run (Context context){
		double x = 15;
		double y = 20;
		context.takeOwnership(Robot.drive);
		context.takeOwnership(Robot.robotPosition); 
		double xpos = Robot.robotPosition.getX();
		double ypos = Robot.robotPosition.getY();
		double angle = Math.atan((y-ypos)/(x-xpos)); //only works when it is reset
		angle = 180*angle/Math.PI;
		Robot.drive.turnAngle(angle, context); // turn angle only turns angle degrees not to angle degrees
		xpos = Robot.robotPosition.getX();
		ypos = Robot.robotPosition.getY();
		double distance = Math.sqrt(((x-xpos)*(x-xpos))+((y-ypos)*(y-ypos)));
		Robot.drive.DriveDistance(distance, context);
		log("X: "+Robot.robotPosition.getX()+"Y: "+Robot.robotPosition.getY());
	}
}