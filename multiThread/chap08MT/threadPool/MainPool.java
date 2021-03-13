/**
 * @title multiThread / chap08MT / threadPool / MainPool.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第８章 WorkerThread / List 8-6, 8-7, 8-8
 * @content ThreadPoolExecutorクラスで WorkerThreadパターンを作成
 * @author shika
 * @date 2021-03-13
 */
package multiThread.chap08MT.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPool {

    public static void main(String[] args) {
        ExecutorService exeService =
            Executors.newFixedThreadPool(5);

        try {
            new ClientThread("Alice", exeService).start();
            new ClientThread("Bobby", exeService).start();
            new ClientThread("Chris", exeService).start();

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            exeService.shutdown();
        }
    }//main()

}//class

/*
pool-1-thread-2 executes [Request from Alice No.0]
pool-1-thread-3 executes [Request from Bobby No.0]
pool-1-thread-1 executes [Request from Chris No.0]
pool-1-thread-4 executes [Request from Alice No.1]
pool-1-thread-5 executes [Request from Bobby No.1]
pool-1-thread-3 executes [Request from Chris No.1]
pool-1-thread-1 executes [Request from Chris No.2]
pool-1-thread-2 executes [Request from Bobby No.2]
pool-1-thread-5 executes [Request from Alice No.2]
pool-1-thread-1 executes [Request from Chris No.3]
pool-1-thread-2 executes [Request from Bobby No.3]
pool-1-thread-3 executes [Request from Alice No.3]
pool-1-thread-4 executes [Request from Alice No.4]
pool-1-thread-1 executes [Request from Chris No.4]
pool-1-thread-5 executes [Request from Bobby No.4]
pool-1-thread-2 executes [Request from Bobby No.5]
pool-1-thread-4 executes [Request from Bobby No.6]
pool-1-thread-4 executes [Request from Alice No.5]
pool-1-thread-2 executes [Request from Bobby No.7]
pool-1-thread-2 executes [Request from Alice No.6]
pool-1-thread-4 executes [Request from Chris No.5]
pool-1-thread-3 executes [Request from Bobby No.8]
pool-1-thread-5 executes [Request from Chris No.6]
pool-1-thread-1 executes [Request from Chris No.7]
pool-1-thread-4 executes [Request from Alice No.7]
pool-1-thread-2 executes [Request from Alice No.8]
  :
(5秒後に強制終了)
Exception in thread "Chris" java.util.concurrent.RejectedExecutionException: Task [Request from Chris No.8] rejected from java.util.concurrent.ThreadPoolExecutor@3dd1c950[Shutting down, pool size = 2, active threads = 2, queued tasks = 0, completed tasks = 25]
    at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2055)
    at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:825)
    at java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1355)
    at multiThread.chap08MT.threadPool.ClientThread.run(ClientThread.java:19)
Exception in thread "Bobby" java.util.concurrent.RejectedExecutionException: Task [Request from Bobby No.8] rejected from java.util.concurrent.ThreadPoolExecutor@3dd1c950[Shutting down, pool size = 2, active threads = 2, queued tasks = 0, completed tasks = 25]
    at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2055)
    at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:825)
    at java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1355)
    at multiThread.chap08MT.threadPool.ClientThread.run(ClientThread.java:19)
Exception in thread "Alice" java.util.concurrent.RejectedExecutionException: Task [Request from Alice No.11] rejected from java.util.concurrent.ThreadPoolExecutor@3dd1c950[Shutting down, pool size = 2, active threads = 2, queued tasks = 0, completed tasks = 25]
    at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2055)
    at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:825)
    at java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1355)
    at multiThread.chap08MT.threadPool.ClientThread.run(ClientThread.java:19)
*/