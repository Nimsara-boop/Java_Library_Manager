package librarycentre_package;

// File: Employee.java
// This class implements Comparable to give Java a "rulebook" for sorting.
public class Employer implements Comparable<Employer> {
    private String name;
    private int salary;

    public Employer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    // This is the "toString" method to make it print nicely
    @Override
    public String toString() {
        return name + " ($" + salary + ")";
    }

    // This is the REQUIRED compareTo method (the "rulebook")
    @Override
    public int compareTo(Employer otherEmployer) {
        // We want to sort by salary in ascending order (lowest first)
        // Returns a negative number if this.salary is less than otherEmployee.salary
        // Returns 0 if they are equal
        // Returns a positive number if this.salary is greater
        //return this.salary - otherEmployee.getSalary();

        // To sort by name instead, you would use:
        return this.name.compareTo(otherEmployer.getName());
    }
}