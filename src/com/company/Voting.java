package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.lang.reflect.Array;
import java.util.*;

/**
 * A class to mange a voting.
 * @author Zahra Ghandi
 * @version 2020
 */
public class Voting {
    // The voting's type.
    private int type;
    // The voting's question.
    private String question;
    // The voters' list.
    private ArrayList<Person> voters;
    // The voting's choices and votes on them.
    private HashMap<String, HashSet<Vote>> choices;

    /**
     * Create a Voting.
     * @param type
     * @param question
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        voters = new ArrayList<>();
        choices = new HashMap<>();
    }

    /**
     * Get the question.
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Add a choice.
     * @param choice
     */
    public void createChoice(String choice) {
        choices.put(choice, new HashSet<Vote>());
    }

    /**
     * Vote.
     * @param person
     * @param voterChoices
     */
    public void vote(Person person, ArrayList<String> voterChoices) {
        if (!voters.contains(person)) {
            voters.add(person);

            if (type == 0) {
                if (choices.containsKey(voterChoices.get(0))) {
                    HashSet<Vote> votes;
                    votes = choices.get(voterChoices.get(0));
                    JalaliCalendar currentDate = new JalaliCalendar();
                    votes.add(new Vote(person, currentDate));
                    choices.replace(voterChoices.get(0), votes);
                } else if (voterChoices.get(0).equals("Random Choice")) {
                    Random rand = new Random();
                    int randInt = rand.nextInt(voterChoices.size());

                    String[] options = choices.keySet().toArray(String[]::new);
                    HashSet<Vote> votes;
                    votes = choices.get(options[randInt]);
                    JalaliCalendar currentDate = new JalaliCalendar();
                    votes.add(new Vote(person, currentDate));
                    choices.replace(options[randInt], votes);
                }
            } else if (type == 1) {
                ArrayList<String> choicesForChecking = new ArrayList<String>();
                for (String voterChoice : voterChoices) {
                    if (!choicesForChecking.contains(voterChoice)) {
                        choicesForChecking.add(voterChoice);
                        if (choices.containsKey(voterChoice)) {
                            HashSet<Vote> votes;
                            votes = choices.get(voterChoice);
                            JalaliCalendar currentDate = new JalaliCalendar();
                            votes.add(new Vote(person, currentDate));
                            choices.replace(voterChoice, votes);
                        }
                    }
                }
            } else {
                System.out.println("Invalid voting type.");
            }
        } else {
            System.out.println("You have already voted.");
        }
    }


    /**
     * Show a list of voters.
     */
    public void printVoters() {
        for(Person voter : voters) {
            System.out.println(voter);
        }
    }

    /**
     * Show a list of votes.
     */
    public void printResult() {
        System.out.println(question);
        Set<String> options = choices.keySet();
        for(String option : options) {
            System.out.print(option + " : " + choices.get(option).size() + " votes  ");
            for (Vote vote : choices.get(option)) {
                System.out.print("| " + vote.getPerson() + "  " + vote.getDate() + " |");
            }
            System.out.println("");
        }
    }

    /**
     * Get the poll options.
     * @return the options
     */
    public ArrayList<String> getChoices() {
        ArrayList<String> pollChoices = new ArrayList<>();
        Set<String> pollSet =  choices.keySet();
        Iterator it = pollSet.iterator();
        while(it.hasNext()) {
            pollChoices.add((String) it.next());
        }

        return pollChoices;
    }
}
