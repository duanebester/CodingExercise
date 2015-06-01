package algorithms;


public class SquareRoot
{
    double THRESHOLD;

    // Recursive function for the successive square root approximations
    private double sqrtRecursiveInner(double a, double x)
    {
        if(Math.abs(x * x - a) > THRESHOLD)
        {
            //System.out.println(Math.abs(x * x - a));

            double y = a / x;
            double guess = (x + y) / 2;
            return sqrtRecursiveInner(a, guess);
        }

        //System.out.println(Math.abs(x * x - a));

        return x;
    }

    /**
     * Method that approximates a Square Root with a tolerance
     * @param a The number we want to find the principal root of.
     * @param epsilon The tolerance for the approximation
     * @return an approximate square root for any real number.
     */
    public double question2(double a, double epsilon)
    {
        THRESHOLD = epsilon;

        double x = a * 0.75;
        return sqrtRecursiveInner(a, x);
    }

    /*
    Questions (answer these):
   1. Why can't the next estimate, xx, be computed as a / x, where x is the previous estimate?

   -- I believe this has to do with convergence. Otherwise we would never approach the approximation in
   -- the right direction.

   2. What happens, in your implementation, if a = 0?

   -- Returns 0.0

   3. What value does your program give for question2(2, 1e-6)?

   -- 1.4142135623746899
     */
}
