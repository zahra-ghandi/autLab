package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    VotingSystem pollManager = new VotingSystem();

	    Person aBoy = new Person("Nima", "Golestan");
	    Person aGirl = new Person("Banafsheh", "Ghoddoosi");
	    Person aWoman = new Person("Kimia", "Alizadeh");
	    Person aMan = new Person("Asghar", "Asgharian");

        ArrayList<String> options = new ArrayList<>();
        options.add("Great");
        options.add("Good");
        options.add("So so");
        options.add("Bad");
        options.add("Awful");
	    pollManager.createVoting("How do you feel?", 0, options);

	    options.clear();
	    options.add("Red");
	    options.add("Yellow");
	    options.add("Green");
	    options.add("Blue");
	    options.add("White");
	    pollManager.createVoting("Which color you like?", 1, options);

		ArrayList<String> personChoiceBoy1 = new ArrayList<>();
		personChoiceBoy1.add("Green");
		personChoiceBoy1.add("Red");
		personChoiceBoy1.add("Red");
		pollManager.vote(1, aBoy, personChoiceBoy1);

		ArrayList<String> personChoiceGirl1 = new ArrayList<>();
		personChoiceGirl1.add("Red");
		pollManager.vote(1, aGirl, personChoiceGirl1);

		pollManager.printListOfVoting();

		pollManager.printResult(1);
    }
}
