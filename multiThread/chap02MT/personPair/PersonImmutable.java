package multiThread.chap02MT.personPair;

public final class PersonImmutable {
    private final String name;
    private final String address;

    public PersonImmutable(String name, String address) {
        this.name = name;
        this.address = address;
    }

//    //BROKENの出たコンストラクタ
//    public PersonImmutable(PersonMutable person) {
//        this.name = person.getName();
//        this.address = person.getAddress();
//    }

    //修正後のコンストラクタ
    public PersonImmutable(PersonMutable person) {
        synchronized(person) {
            this.name = person.getName();
            this.address = person.getAddress();
        }
    }

    @Override
    public String toString() {
        return String.format(
            "[PersonImmutable: %s, %s]", name, address);
    }//toString()

    public PersonMutable getPersonMutable() {
        return new PersonMutable(this);
    }

    //==== getter ====
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}//class

