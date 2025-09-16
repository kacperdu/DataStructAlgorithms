package assignment2;

import java.util.LinkedList;

public class Greedy {

    public static LinkedList<Activity> activitySelection(LinkedList<Activity> activities) {
        // TASK 1.B.a
        LinkedList<Activity> selectedActivities = new LinkedList<>(); // Create empty linkedlist to store activities we want

        // Check if empty
        if (activities.isEmpty()) { // Checking if list of activities is empty
            return selectedActivities; // If so return empty list
        }

        else {
            Activity firstActivity = activities.get(0); // Since we assume the list is already sorted, the first
                                                        // activity will be the most optimal start
            int listSize = activities.size(); // get size of list of activities

            for (int i = 0; i < listSize; i++){ // iterate through list of activities
                Activity currentActivity = activities.get(i); // Get current activity being iterated through
                if (firstActivity.overlap(currentActivity) == false){ // If comparison of the two activities
                                                                      // doesn't result in an overlap
                    selectedActivities.add(currentActivity); // Add the checked activity to list
                    firstActivity = currentActivity; // Current activity becomes new activity for overlap comparison
                }
            }
            return selectedActivities;
        }
    }

    public static LinkedList<Integer> makeChange(int amount, int[] denominations) {
        // TASK 1.B.b
        LinkedList<Integer> minAmount = new LinkedList<>(); // Create empty linkedlist to store ints we want

        int listSize = denominations.length; // Get amount of denominations
        for (int i = 0; i < listSize; i++){ // Iterate through denominations
            int currentDenom = denominations[i]; // Store current denomination value at current index value
            while (amount >= currentDenom){ // While amount is larger or equal to current denomination value
                minAmount.add(currentDenom); // Add checked value to list
                amount = amount - currentDenom; // Subtract checked value from amount
            }
        }
        return minAmount;

    }

    public static void main(String[] args) {
        LinkedList<Activity> activities = new LinkedList<Activity>();
        activities.add(new Activity(1,1, 4));
        activities.add(new Activity(2, 3, 5));
        activities.add(new Activity(3, 0, 6));
        activities.add(new Activity(4, 5, 7));
        activities.add(new Activity(5, 3, 8));
        activities.add(new Activity(6, 5, 9));
        activities.add(new Activity(7, 6, 10));
        activities.add(new Activity(8, 8, 11));
        activities.add(new Activity(9, 8, 12));
        activities.add(new Activity(10, 2, 13));
        activities.add(new Activity(11, 12, 14));
        activitySelection(activities).forEach(a -> a.print());

        System.out.println();
        makeChange(1234, new int[] { 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 }).forEach(i -> System.out.println(i));
    }
}
