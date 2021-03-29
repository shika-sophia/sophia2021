package multiThread.chap12MT.swingAnsConcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SearcherImpl implements Searcher {
    private final ExecutorService exeService =
                Executors.newSingleThreadExecutor();

    @Override
    public void search(String word, Display display) {
        class SearchRequest implements Runnable {
            public void run() {
                System.out.println("search(" + word + ")");

                IntStream.range(0, 50).boxed()
                    .map(i -> ".")
                    .peek(s -> {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    })
                    .forEachOrdered(System.out::print);

                System.out.println("seach() found.");
                String url = "http://somewhere/" + word + ".html";
                display.display(
                    String.format("word = %s, URL = %s", word, url));
            }//run()
        }//class SearchRequest

        exeService.execute(new SearchRequest());
    }//search()

    public void shutdown() {
        exeService.shutdown();
    }

}//class
