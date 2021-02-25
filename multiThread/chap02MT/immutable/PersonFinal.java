package multiThread.chap02MT.immutable;

public final class PersonFinal {
    private final String name;
    private final String address;

    public PersonFinal(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format(
            " [Person name: %s, address: %s]", name, address);
    }//toString()

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}//class
