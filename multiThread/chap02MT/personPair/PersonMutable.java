package multiThread.chap02MT.personPair;

public class PersonMutable {
    private String name;
    private String address;

    public PersonMutable(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public PersonMutable(PersonImmutable person) {
        this.name = person.getName();
        this.address = person.getAddress();
    }

    @Override
    public String toString() {
        return String.format(
            "[PersonMutable: %s, %s]", name, address);
    }//toString()

    //==== synchronized ====
    public synchronized void setPerson(String nameNew, String addressNew) {
        this.name = nameNew;
        this.address = addressNew;
    }

    public synchronized PersonImmutable getPersonImmutable() {
        return new PersonImmutable(this);
    }

    //==== getter ====
    String getName() { //package-private
        return name;
    }

    String getAddress() { //package-private
        return address;
    }


}//class
