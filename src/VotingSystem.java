import java.util.ArrayList;

/**
 * this class present date present info about all the voting
 *
 * @author Narges Salehi
 */
public class VotingSystem {
    // list of voting
    private ArrayList<Voting> votingList;

    /**
     * creat a new voting system
     */
    public VotingSystem() {
        votingList = new ArrayList<>();
    }

    /**
     * creat a new voting by given parameters
     *
     * @param question of the voting
     * @param type     of voting
     * @param options  of voting
     * @return a new voting
     */
    public void creatVoting(int type, String question, ArrayList<String> options) {
        Voting voting = new Voting(type, question, options);
        votingList.add(voting);
    }

    /**
     * this method print all the voting question
     */
    public void printVotingQuestions() {
        System.out.println("List Of Each Voting Questions :");
        for (Voting voting : votingList) {
            System.out.println(voting.getQuestion());
        }
    }

    /**
     * print the given voting number
     *
     * @param index the voting we want to print its question
     */
    public void printVoting(int index) {
        System.out.println("The Question of Voting Is : " + votingList.get(index).getQuestion());
        System.out.println("The Options Are : " + votingList.get(index).getChoices());

    }

    /**
     * add a vote with given data in the voting
     *
     * @param index   of voting
     * @param person  voter
     * @param choices option to vote for
     */
    public void vote(int index, Person person, ArrayList<String> choices) {
        //this check type of voting for number of options to vote
        if (votingList.get(index).getType() == 0) {
            //see if you are voting only on option
            if (choices.size() == 1) {
                votingList.get(index).vote(person, choices);
            } else
                System.out.println("This Voting is type 0!");
        } else
            votingList.get(index).vote(person, choices);
    }

    /**
     * this method delete intended voting
     *
     * @param votingToDelete the voting has to be deleted
     */
    public void deleteVoting(Voting votingToDelete) {
        //this remove intended voting
        votingList.remove(votingToDelete);
    }

    /**
     * this method print intended voting
     *
     * @param index the index of intended voting
     */
    public void printResult(int index) {
        //get the intended voting and print the votes
        votingList.get(index).printVotes();

    }

    public ArrayList getVotingList(){
        return votingList;
    }}

