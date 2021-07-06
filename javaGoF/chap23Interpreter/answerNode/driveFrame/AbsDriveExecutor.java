package javaGoF.chap23Interpreter.answerNode.driveFrame;

import javaGoF.chap23Interpreter.answerNode.language.INodeExecutor;

public abstract class AbsDriveExecutor implements INodeExecutor {
    protected DriveCanvas canvas;

    public AbsDriveExecutor(DriveCanvas canvas) {
        this.canvas = canvas;
    }

    public abstract void execute();

}//class
