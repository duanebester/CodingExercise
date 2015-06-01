package algorithms;


import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates
{
    /**
     * Method removes duplicate ints from an int array.
     * @param input The array with duplicates. Assumes array
     *              is sorted from low to high, also assumes
     *              array has non-negative numbers.
     * @return The sorted array.
     */
    int[] question1(final int[] input)
    {
        // Create a blank array the size of the input array
        int[] test = new int[input.length];

        // An index to keep track of non-duplicates
        int newIndex = 0;

        // Set the first value
        test[newIndex] = input[0];

        // Loop through the input array
        for(int i = 1; i < input.length; i++)
        {
            // Add to test array if not a duplicate
            if(test[newIndex] != input[i])
            {
                // Keep track of index
                newIndex ++;
                test[newIndex] = input[i];
            }
        }

        // Create a return array the size of the non-duplicate count
        int[] toReturn = new int[newIndex+1];

        // Copy from test array the non-duplicates
        for(int j = 0; j < newIndex+1; j++)
        {
            toReturn[j] = test[j];
        }

        return toReturn;
    }

     /*
    Questions (answer these):
   1. Did you write that as if you were writing production code?

   -- I Wrote it as if I was writing very fast production code.

   2. What assumptions does your implementation make about the input parameter?

   -- That the Array is sorted from low to high, and that it's non-negative.

   3. What is question1(x).length, in your implementation?

   -- The length of the array with no duplicates.

   4. Are you using all the information you have about the input array?

   -- I'm sure that I'm not.

   5. What is the algorithmic complexity ("big O") of your function?

   -- Somewhere around 2 * O(n)
     */

    /**
     * Method removes duplicate values from a List of Integers.
     * @param values A sorted List<Integer>.
     * @return A List<Integer> of non-duplicates.
     */
    List<Integer> question1(final List<Integer> values)
    {
        List<Integer> newList = new ArrayList<Integer>();

        int i;

        // Loop through and add  non-duplicates
        for (i = 0; i < values.size() - 1; i++)
        {
            Integer a1 = values.get(i);
            Integer a2 = values.get(i+1);

            if (!a1.equals(a2))
            {
                newList.add(a1);
            }
        }

        // Test to see if the last value in the new list is equal to the last value of Input
        if(!newList.get(newList.size()-1).equals(values.get(i)))
        {
            newList.add(values.get(i));
        }

        return newList;
    }

    /*
    Questions (answer these):
   1. What is the algorithmic complexity ("big O") of your function? the size complexity?

   -- I'm not sure; with an ArrayList I know the read operation is O(1)
   -- however, for adding n elements, the time is O(n).

   2. What would you change for the implementation to work for other numeric classes and generic objects?

   -- Probably the override equals method of the generic. There might need to be some additional sorting issues to
   -- be thought out. As in, since we assume a sorted order, how do we know if a Lion object is the same as
   -- another Lion object?

     */
}
