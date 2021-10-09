package com.team766.frc2020;

import com.team766.framework.AutonomousProcedure;
import com.team766.frc2020.procedures.*;

public enum AutonomousModes {
	@AutonomousProcedure(procedureClass = DoNothing.class) 
	DoNothing,
	@AutonomousProcedure(procedureClass = GoToPoint.class) 
	GoToPoint,
	@AutonomousProcedure(procedureClass = FollowLine.class) 
	FollowLine,
	@AutonomousProcedure(procedureClass = TurnAngle.class) 
	TurnAngle,
	@AutonomousProcedure(procedureClass = DriveDistance.class) //takes class as like a parameter, creates instance and runs run procedure (in runnablewithcontext)
	DriveDistance,
	@AutonomousProcedure(procedureClass = IntakeBalls.class)
	IntakeBalls,
	@AutonomousProcedure(procedureClass = Launch.class)
	Launch,
	@AutonomousProcedure(procedureClass = DriveSquare.class)
	DriveSquare,
	@AutonomousProcedure(procedureClass = TurnRight.class)
	TurnRight,
	@AutonomousProcedure(procedureClass = DriveStraight.class)
	DriveStraight,
}
