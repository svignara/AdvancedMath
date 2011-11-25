package advancedmath;

/**
 * @author Fahd Ananta
 */
public class AdvancedMath {

    private static class ComplexNumberException extends Exception {

        public ComplexNumberException() {
            super("Exception: Complex number generated");
        }
    }

    public static int randInt(int lower, int upper) {
        int low = (upper < lower) ? upper : lower;
        int hi = (lower > upper) ? lower : upper;

        return (int) Math.rint(Math.abs(hi - low) * Math.random()) + low;
    }

    public static double cosh(double x) {
        return (0.5 * (Math.exp(-1 * x) + Math.exp(x)));
    }

    public static double sinh(double x) {
        return (0.5 * ((-1) * Math.exp(-1 * x) + Math.exp(x)));
    }

    public static double tanh(double x) {
        return (sinh(2 * x)) / (cosh(2 * x) + 1);
    }

    public static double acosh(double x) throws ComplexNumberException {
        if (((-1 + x) < 0) || ((1 + x) < 0)) {
            throw new ComplexNumberException();
        }
        return Math.log(x + (Math.sqrt(-1 + x) * Math.sqrt(1 + x)));
    }

    public static double asinh(double x) throws ComplexNumberException {
        double innerResult = x + Math.sqrt(1 + Math.pow(x, 2.0));
        if (innerResult <= 0) {
            throw new ComplexNumberException();
        }
        return Math.log(innerResult);
    }

    public static double atanh(double x) throws ComplexNumberException {
        if ((x <= -1) || (x >= 1)) {
            throw new ComplexNumberException();
        }
        return (0.5 * (Math.log(1 + x) - Math.log(1 - x)));
    }

    public static void main(String[] args) {
        try {
            System.out.println(atanh(0.5));
        } catch (ComplexNumberException e) {
            System.err.println(e.getMessage());
        }
    }
}
