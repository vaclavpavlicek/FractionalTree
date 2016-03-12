package cz.vendasky;

public class FractionalTree {

    private Fraction actualFraction;
    private String path;

    public FractionalTree(int startNumerator, int startDenominator) {
        this.actualFraction = new Fraction(startNumerator, startDenominator);
        this.path = "";
    }


    public Fraction getActualFraction() {
        return actualFraction;
    }

    public void generateParentOfActualFraction() {
        if (this.actualFraction.getNumerator() > this.actualFraction.getDenominator()) {
            this.actualFraction = new Fraction(this.actualFraction.getNumerator() - this.actualFraction.getDenominator(),
                    this.actualFraction.getDenominator());
            path += "R";
        } else {
            this.actualFraction = new Fraction(this.actualFraction.getNumerator(),
                    this.actualFraction.getDenominator() - this.actualFraction.getNumerator());
            path += "L";
        }
    }

    public boolean checkIfRootFound() {
        return this.actualFraction.getNumerator() == 1 && this.actualFraction.getDenominator() == 1;
    }

    public void findPathToRoot() {
        while (!checkIfRootFound()) {
            generateParentOfActualFraction();
        }
    }

    public String getPath() {
        return new StringBuilder(path).reverse().toString();
    }
}
