package com.company;

/**
 * Holds students' details
 * @author Zahra
 */
public class Student {

    private String firstName;
    private String lastName;
    private String id;
    private int grade;

    /**
     * constructor for Student class
     */
    public Student(String fName, String lName, String sID) {
        firstName = fName;
        lastName = lName;
        id = sID;
        grade = 0;
    }

    /**
     * getter firstName
     * @return
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * getter lastName
     * @return
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * getter id
     * @return
     */
    public String getId() {
        return id;
    }
    /**
     * getter getGrade
     * @return
     */
    public int getGrade() {
        return grade;
    }

    /**
     * setter firstName
     * @return
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * setter lastName
     * @return
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * setter id
     * @return
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * setter grade
     * @return
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     *print detail
     */
    public void print() {
        System.out.println(lastName + ", student ID: " + ", grade: " + grade);
    }
}

/**
 * lab class
 *
 * @author Zahra
 */
public class LAB {
    private Student[] students;
    private int avg;
    private String day;
    private int capacity;
    private int currentSize;
    public Lab(int cap, String d) {
        capacity = cap;
        day = d;
    }

    /**
     * enroll students
     * @param std
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!");
        }
    }

    /**
     * prints student data
     */
    public void print() {
        for (int i = 0; i < students.length(); i++) {
            System.out.println("std fName: " + students[i].getFirstName() + "std lName:" + students[i].getLastName(), "std id:" + students[i].getId() + " std grade:" + students[i].getGrade());
        }
            System.out.println("LAB AVG:" + avg);
    }
    public student[] getStudents() {
        return students;
    }
    public void setStudents(Student[students]) {

    }
    public int getAvg() {
        f
    }
    public void calculateAvg() {}
    public String getDay() {}
    public void setDay(String day) {}
    public int getCapacity() {}
    public void setCapacity(int capacity) {}
}

public class Main {

    public static void main(String[] args) {
        Student std1 = new Student("Zahra", "Ghandi", "9831049");
        Student std2 = new Student("Parastoo", "Azad", "9831003");
        Student std3 = new Student("Rooh", "Ahmad", "98310001");

        std1.print();
        std1.setGrade(15);
        std1.print();

        std2.print();
        std2.setGrade(11);
        std2.print();

        std3.print();
        std3.setFirstName("Mehdi");
        std3.print();
    }
}
