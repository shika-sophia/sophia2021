package multiThread.chap12MT.activeObjectPattern.activeObject;

class ShowRequest extends AbsRequest<String> {
    private final String str;

    public ShowRequest(Servant servant, String str) {
        super(servant, null);
        this.str = str;
    }

    @Override
    public void execute() {
        servant.showString(str);
    }//execute()

}//class
