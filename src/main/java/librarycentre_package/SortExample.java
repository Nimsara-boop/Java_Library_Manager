package librarycentre_package;

// File: SortExample.java
import java.util.Arrays;

public class SortExample {
    public static void main(String[] args) {
        // 1. Create an array of Employee objects
        Employer[] staff = new Employer[5];
        staff[0] = new Employer("Dan", 70000);
        staff[1] = new Employer("Ben", 90000);
        staff[2] = new Employer("Ann", 50000);
        staff[3] = new Employer("Zen", 80000);
        staff[4] = new Employer("Cindy", 110000);

        System.out.println("Before sorting: " + Arrays.toString(staff));

        // 2. Sort the array
        // Java sees the "implements Comparable" and knows how to sort
        // It will use the compareTo method we wrote
        Arrays.sort(staff);

        // 3. Print the sorted array
        System.out.println("After sorting: " + Arrays.toString(staff));
    }
}