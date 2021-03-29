package multiThread.chap12MT.swingAnsConcurrent;

public class SearchFacory {
    public static Searcher createSearcher() {
        return new SearcherImpl();
    }
}//class
