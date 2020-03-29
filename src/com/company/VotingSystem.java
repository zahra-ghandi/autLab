package com.company;

import java.util.ArrayList;

/**
 * A class to manage all the polls.
 */
public class VotingSystem {
    // A list of votings.
    private ArrayList<Voting> votingList;

    /**
     * Create a VotingSystem.
     */
    public VotingSystem() {
        votingList = new ArrayList<>();
    }

    /**
     * Creat a poll.
     * @param question
     * @param type
     * @param options
     */
    public void createVoting(String question, int type, ArrayList<String> options) {
        Voting poll = new Voting(type, question);
        for(String option : options) {
            poll.createChoice(option);
        }
        votingList.add(poll);
    }

    /**
     * Show a list of all the polls.
     */
    public void printListOfVoting() {
        for(Voting voting : votingList) {
            System.out.println(voting.getQuestion());
            System.out.println("");
        }
    }

    /**
     * Show a certain poll.
     * @param index
     */
    public void printVoting(int index) {
        System.out.println(votingList.get(index));
    }

    /**
     * Add someone's vote.
     * @param pollIndex
     * @param person
     * @param choices
     */
    public void vote(int pollIndex, Person person, ArrayList<String> choices) {
        votingList.get(pollIndex).vote(person, choices);
    }

    /**
     * Show the result of a specific poll.
     * @param pollIndex
     */
    public void printResult(int pollIndex) {
        votingList.get(pollIndex).printResult();
    }
}
