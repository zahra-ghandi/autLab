package com.company;

import ir.huri.jcal.JalaliCalendar;

/**
 * A class to save details of a vote.
 * @author Zahra Ghandi
 * @version 2020
 */
public class Vote {
    // The voting Person
    private Person person;
    // The date of voting
    private JalaliCalendar date;

    /**
     * Create a Vote.
     * @param person
     * @param date
     */
    public Vote(Person person, JalaliCalendar date) {
        this.person = person;
        this.date = date;
    }

    /**
     * Get person.
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Get date.
     * @return date
     */
    public JalaliCalendar getDate() {
        return date;
    }

    /**
     * Check if the two Vote objects are equal.
     * @param voteToCheck
     * @return true if the objects are equal and false if they are not.
     */
    public boolean equals(Vote voteToCheck) {
        if(this == voteToCheck) {
            return true;
        }

        if(!(voteToCheck instanceof Vote)) {
            return false;
        }

        return voteToCheck.getPerson() == person && voteToCheck.getDate() == date;
    }

    /**
     * Create HashCode.
     * @return result
     */
    public int hashCode() {
        int result = 17;
        result = 37 * result + person.hashCode();
        result = 37 * result + date.hashCode();
        return result;
    }
}
