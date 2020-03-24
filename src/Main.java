import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;

/**
 * this class test the methods
 * @author Narges salehi
 */
public class Main {
    public static void main(String[] args) {
        //creating new voting system
        VotingSystem votingsystem = new VotingSystem();
        //creat a new person or voter
        Person voter = new Person("Narges", "Salehi");
        //creat a new array list for question options
        ArrayList options = new ArrayList();
        ArrayList days = new ArrayList();
        //adding choices
        options.add("Yes");
        options.add("No");
        options.add("Random");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        //creat a new voting
        votingsystem.creatVoting(0, "Do you come ?", options);
        votingsystem.creatVoting(1, "Which day?",days );
        System.out.println("print voting Question :");
        //printing each voting questions
        votingsystem.printVotingQuestions();
        System.out.println("\nprint voting :");
        //printing each voting question + options
        votingsystem.printVoting(0);
        votingsystem.printVoting(1);
        //creat new array list of choices which have been voted for
        ArrayList<String> votes1 = new ArrayList();
        votes1.add("Yes");
        ArrayList<String> votes3=new ArrayList();
        votes3.add("No");
        //this array list if for random vote
        ArrayList<String> votes5=new ArrayList<>();
        votes5.add("Random");
        ArrayList<String> votes2 = new ArrayList();
        votes2.add("Thursday");
        votes2.add("Friday");
        votes2.add("Saturday");
        ArrayList<String> votes4=new ArrayList<>();
        votes4.add("Friday");
        //start voting 0
        //two persons vote for yes
        System.out.println("\nstart voting :");
        votingsystem.vote(0, new Person("Sara", "Salehi"),votes1);
        votingsystem.vote(0,voter,votes1);
        //this check if a person can vote twice or can't
        votingsystem.vote(0, new Person("Sara", "Salehi"),votes3);
        //one more vote for no
        votingsystem.vote(0,new Person("Saeed","Salehi"),votes3);
        // one vote for random which count yes or no each time
        votingsystem.vote(0,new Person("Ava","Salehi"),votes5);
        // start voting 1
        //two person vote for thursday and friday and saturday
        votingsystem.vote(1, new Person("Sara", "Salehi"),votes2);
        votingsystem.vote(1,voter,votes2);
        //this person vote for friday
        votingsystem.vote(1,new Person("Hanieh","Salehi"),votes4);
        //this check if a person can vote twice or can't
        votingsystem.vote(1,voter,votes4);
        //this print final result of voting
        System.out.println("\nprint result :");
        votingsystem.printResult(0);
        votingsystem.printResult(1);
        //check if equals method work well
        JalaliCalendar date=new JalaliCalendar();
        Vote vote1=new Vote(voter,date.toString());
        Vote vote2=new Vote(voter,date.toString());
        System.out.println("\nThis two votes are :"+vote1.equals(vote2));
        String n="narge sna rges nar ";
        n.split("narges");
        System.out.println(n.trim()+".");

    }
}
