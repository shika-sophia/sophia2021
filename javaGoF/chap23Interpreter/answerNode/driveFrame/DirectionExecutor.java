package javaGoF.chap23Interpreter.answerNode.driveFrame;

public class DirectionExecutor extends AbsDriveExecutor {
	private int turnDirection;
	
	public DirectionExecutor(DriveCanvas canvas, int turnDirection) {
		super(canvas);
		this.turnDirection = turnDirection;
	}

	@Override
	public void execute() {
		canvas.setTurnDirection(turnDirection);
	}

}//class
