import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * this class give info about a voting
 *
 * @author Narges Slaehi
 */
public class Voting {
    //type declare how many option you can vote for ,one or more
    private int type;
    //question of voting
    private String question;
    //list of voters to this voting
    private ArrayList<Person> voters;
    //list of options
    private ArrayList<String> choices;
    //Hash set for votes
    private HashSet<Vote> listOfVotes;
    //Hash map of a question and a Hash set of Vote for this question
    private HashMap<String, HashSet<Vote>> listOfVotesToChoices;

    /**
     * creat a new voting
     *
     * @param type     of voting
     * @param question question of voting
     * @param choices  list of options
     */
    public Voting(int type, String question, ArrayList<String> choices) {
        this.type = type;
        this.question = question;
        this.choices = choices;
        voters = new ArrayList<>();
        listOfVotes = new HashSet<>();
        listOfVotesToChoices = new HashMap<>();
        //assign a hash set for each string of choices
        for (String choice : choices) {
            HashSet hash = new HashSet();
            listOfVotesToChoices.put(choice, hash);
        }
    }

    /**
     * this method return type of voting
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * get the option list
     *
     * @return choices
     */
    public ArrayList<String> getChoices() {
        return choices;
    }

    /**
     * get the question
     *
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * add a new option to voting
     *
     * @param choice we want to add
     */
    public void createChoice(String choice) {
        choices.add(choice);
    }

    /**
     * add a new vote to voting by given person and choices
     * @param person  who voted
     * @param choices were voted
     */
    public void vote(Person person, ArrayList<String> choices) {
        //creat date in shamsi to creat vote
        JalaliCalendar date = new JalaliCalendar();
        //check if voter has voted to this voting before , also see if person has voted for voting type 0
        boolean check = false;
        for (Person voter : voters) {
            //check out voters list to find this person
            if (voter.getFirstName().equals(person.getFirstName())
                    && voter.getLastName().equals(person.getLastName())) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Person voted before!");
        }
        //submit the new vote
        else {
            Vote vote = new Vote(person, date.toString());
            //check for random
            for (String choice : choices) {
                if (choice.equals("Random")) {
                    Random r = new Random();
                    boolean check1 = r.nextBoolean();
                    //here till 4 line below use random boolean and vote randomly
                    if (check1)
                        listOfVotesToChoices.get("Yes").add(vote);
                    if (!check1)
                        listOfVotesToChoices.get("No").add(vote);
                    break;
                }
                //submit the vote
                else if (listOfVotesToChoices.containsKey(choice))
                    listOfVotesToChoices.get(choice).add(vote);
            }
            //add person to voters
            this.voters.add(person);
            System.out.println("vote added.");
        }
    }

    /**
     * this method goes through voters and print a list of them
     */
    public void getVoters() {
        if (voters.size() == 0)
            System.out.println("No One Voted Yet !");
        if (voters.size() != 0) {
            System.out.println("List Of Voters:");
            for (Person voter : voters)
                System.out.println(voter.getFirstName() + voter.getLastName());
        }
    }

    public void printVotes() {
        for (String choice : choices) {
            //check to not print random as a option instead print sth else
            if (choice.equals("Random"))
                break;
            if (listOfVotesToChoices.containsKey(choice)) {
                //print result of each option
                System.out.println(choice + "->" + listOfVotesToChoices.get(choice).size());
                for(Vote vote:listOfVotesToChoices.get(choice))
                    //print voters and date
                System.out.println("voter :"+vote.getPerson().getFirstName()+
                        " "+vote.getPerson().getLastName()+" | "+"date :"+vote.getDate());
            }
        }
    }
}




