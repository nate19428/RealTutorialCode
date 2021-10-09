package com.team766.frc2020.procedures;
 
import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.frc2020.Robot;

public class FollowLine extends Procedure {
 
	public void run(Context context) {
		context.takeOwnership(Robot.drive);
		context.takeOwnership(Robot.lineSensors);
 
		while (true) {
			// Add line following code here
			if (Robot.lineSensors.getLineSensorLeft() == true){
				Robot.drive.setArcadeDrivePower(0.0,-0.1);
				log("turning left");
			} else if (Robot.lineSensors.getLineSensorCenter() == true){
				Robot.drive.setArcadeDrivePower(0.1,0.0);
				log("going straight");
			} else if (Robot.lineSensors.getLineSensorRight() == true){
				Robot.drive.setArcadeDrivePower(0.0,0.1);
				log("turning right");
			} else{
				Robot.drive.setArcadeDrivePower(0.0,-0.03);
				log("turning left slowly");
			}
			
			context.yield();
		}
	}
 
}
