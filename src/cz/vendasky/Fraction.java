package cz.vendasky;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    @Override
    public boolean equals(Object fraction) {
        return fraction instanceof Fraction
                && this.numerator == ((Fraction) fraction).numerator
                && this.denominator == ((Fraction) fraction).denominator;
    }
}
