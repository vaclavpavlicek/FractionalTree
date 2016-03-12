package cz.vendasky;

public class Fraction {

    private long numerator;
    private long denominator;

    public Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public long getNumerator() {
        return this.numerator;
    }

    public long getDenominator() {
        return this.denominator;
    }

    @Override
    public boolean equals(Object fraction) {
        return fraction instanceof Fraction
                && this.numerator == ((Fraction) fraction).numerator
                && this.denominator == ((Fraction) fraction).denominator;
    }
}
