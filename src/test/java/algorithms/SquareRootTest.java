package algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SquareRootTest
{
    SquareRoot squareRoot;

    double input1 = 16.2;

    double input2 = 0;

    double input3 = 2;

    double epsilon = 0.0001;

    double oneEEneg6 = 0.000001;

    double output1, output2, output3;


    @Before
    public void setUp() throws Exception
    {
        squareRoot = new SquareRoot();

        output1 = squareRoot.question2(input1, epsilon);

        output2 = squareRoot.question2(input2, epsilon);   // 0.0

        output3 = squareRoot.question2(input3, oneEEneg6); // 1.4142135623746899
    }

    @Test
    public void testSquareRootPositive() throws Exception
    {
        assertTrue(Math.abs(input1 - (output1 * output1)) < epsilon);
    }

    @Test
    public void testSquareRootZero() throws Exception
    {
        assertEquals(output2, 0.0, epsilon);
    }

    @Test
    public void testSquareRootSmallEpsilon() throws Exception
    {
        assertTrue(Math.abs(input3 - (output3 * output3)) < oneEEneg6);
    }
}