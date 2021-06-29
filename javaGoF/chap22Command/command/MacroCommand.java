package javaGoF.chap22Command.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MacroCommand implements ICommand {
    private Deque<ICommand> cmdDeq = new ArrayDeque<>();

    @Override
    public void execute() {
        Iterator<ICommand> cmdItr = cmdDeq.iterator();

        while(cmdItr.hasNext()) {
            cmdItr.next().execute();
        }//while
    }//execute()

    //命令の追加
    public void append(ICommand cmd) {
        if(cmd != this) {     //this追加するとexecute()ループするので除外
            cmdDeq.push(cmd); // =addFirst()
        }
    }//append()

    //命令を１つ削除
    public void undo() {
        if(!cmdDeq.isEmpty()) {
            cmdDeq.pop(); // =removeFirst()
        }
    }//undo()

    //命令を全て削除
    public void clear() {
        cmdDeq.clear();
    }//clear()

}//class
