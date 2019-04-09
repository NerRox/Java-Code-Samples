package SeriousAssigments;

import java.util.Objects;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 &&
                Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public static void main(String[] args) {
        ComplexNumber x = new ComplexNumber(1.5, 6);
        ComplexNumber y = new ComplexNumber(1.5, 7);

        System.out.println(x.equals(y));
        System.out.println(x.hashCode());
    }
}