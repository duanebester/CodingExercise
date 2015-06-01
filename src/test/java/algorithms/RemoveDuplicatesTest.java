package algorithms;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RemoveDuplicatesTest
{
    RemoveDuplicates removeDuplicates;

    final int[] input1 = new int[]{ 1, 2, 3, 4, 4, 5 };
    final int[] input2 = new int[]{ 1, 1, 2, 3, 4, 4, 5, 5, 5, 5 };
    final int[] input3 = new int[]{ 0, 1, 1, 2, 3, 4, 4, 5, 5, 5, 5 };

    int[] output1;
    int[] output2;
    int[] output3;

    final int[] expected = new int[]{ 1, 2, 3, 4, 5 };

    final List<Integer> inputList1 = Arrays.asList(1, 2, 3, 4, 4, 5);
    final List<Integer> inputList2 = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5, 5, 5);
    final List<Integer> inputList3 = Arrays.asList(0, 1, 1, 2, 3, 4, 4, 5, 5, 5, 5);

    List<Integer> outputList1;
    List<Integer> outputList2;
    List<Integer> outputList3;

    final List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5);

    @Before
    public void setUp() throws Exception
    {
        removeDuplicates = new RemoveDuplicates();

        output1 = removeDuplicates.question1(input1);
        output2 = removeDuplicates.question1(input2);
        output3 = removeDuplicates.question1(input3);

        outputList1 = removeDuplicates.question1(inputList1);
        outputList2 = removeDuplicates.question1(inputList2);
        outputList3 = removeDuplicates.question1(inputList3);
    }

    @Test
    public void testRemoveDuplicatesLength() throws Exception
    {
        assertEquals("Expect Array lengths 1 to be the same", expected.length, output1.length);
        assertEquals("Expect Array lengths 2 to be the same", expected.length, output2.length);
    }

    @Test
    public void testRemoveDuplicatesEqual() throws Exception
    {
        assertArrayEquals("Test array's are the same", expected, output1);
        assertArrayEquals("Test array's are the same", expected, output2);
    }

    @Test
    public void testRemoveDuplicatesNotEqual() throws Exception
    {
        assertThat(expected, IsNot.not(IsEqual.equalTo(output3)));
    }

    @Test
    public void testRemoveDuplicatesLengthList() throws Exception
    {
        assertEquals("Expect List sizes to be the same", expectedList.size(), outputList1.size());
        assertEquals("Expect List sizes to be the same", expectedList.size(), outputList2.size());
    }

    @Test
    public void testRemoveDuplicatesEqualList() throws Exception
    {
        assertEquals("Test Lists are the same", expectedList, outputList1);
        assertEquals("Test Lists are the same", expectedList, outputList2);
    }

    @Test
    public void testRemoveDuplicatesNotEqualList() throws Exception
    {
        assertThat(expectedList, IsNot.not(IsEqual.equalTo(outputList3)));
    }
}
