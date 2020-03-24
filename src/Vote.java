import ir.huri.jcal.JalaliCalendar;
import java.util.Objects;

/**
 * this class save data about a vote
 * @author Narges Salehi
 */
public class Vote {
    //voter
    private Person person;
    //date of voting in shamsi
    private String date;

    /**
     * creat a new vote with given data
     * @param person voter
     * @param date date of vote in  shamsi
     */
    public Vote(Person person, String date) {
        this.person = person;
        this.date = date;
    }
    /**
     * creat a new vote
     */
    public Vote() {
        this.person = person;
        this.date = date;
    }

    /**
     * return the voter
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * return date of vote
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * this method compare the current object with given object
     * @param o given object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return person.equals(vote.person) &&
                date.equals(vote.date);
    }

    /**
     * this method set hashcode for each vote
     * @return Objects.hash(person, date)
     */
    @Override
    public int hashCode() {
        return Objects.hash(person, date);
    }
}
