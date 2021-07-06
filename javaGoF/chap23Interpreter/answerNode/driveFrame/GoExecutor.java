package javaGoF.chap23Interpreter.answerNode.driveFrame;

public class GoExecutor extends AbsDriveExecutor {

    public GoExecutor(DriveCanvas canvas) {
        super(canvas);
    }

    @Override
    public void execute() {
        canvas.go(DriveCanvas.LENGTH);
    }

}//class
