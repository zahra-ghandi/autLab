package com.company;

/**
 * A class to save a person's information.
 * @author Zahra Ghandi
 * @version 2020
 */
public class Person {
    // The person's first name.
    private String firstName;
    // The person's last name.
    private String lastName;

    /**
     * Create a Person.
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Get the person's first name.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the person's last name.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Make an String from the information.
     * @return String format of the information.
     */
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * Check if the two Person objects are equal.
     * @param personToCheck
     * @return true if the two persons are the same and false if they're not.
     */
    public boolean equals(Person personToCheck) {
        if (this == personToCheck) {
            return true;
        }

        if (!(personToCheck instanceof Person)) {
            return false;
        }

        if ((this.firstName == personToCheck.firstName) && (this.lastName == personToCheck.firstName)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Create HashCode.
     * @return result
     */
    public int hashCode() {
        int result = 17;
        result = 37 * result + firstName.hashCode();
        result = 37 * result + lastName.hashCode();
        return result;
    }
}
