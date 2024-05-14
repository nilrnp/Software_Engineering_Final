import java.util.ArrayList;
import java.util.List;

// Base class for users
abstract class User {
    protected String name;
    protected String address;
    protected String county;

    public User(String name, String address, String county) {
        this.name = name;
        this.address = address;
        this.county = county;
    }
}