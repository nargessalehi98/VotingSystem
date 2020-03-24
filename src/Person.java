import java.security.PrivateKey;

/**
 * this class give data about voter
 * @author narges Salehi
 */
public class Person {
    //first name of voter
    private String firstName;
    //last name of voter
    private String lastName;

    /**
     * this creat a new person
     * @param firstName first name of voter
     * @param lastName  last name of voter
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * give first name of voter
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * give last name of voter
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
}
