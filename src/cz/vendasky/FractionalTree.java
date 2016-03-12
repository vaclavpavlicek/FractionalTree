package cz.vendasky;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FractionalTree {

    private Fraction actualFraction;
    private String path;

    private FractionalTree(int startNumerator, int startDenominator) {
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

    public static String readFromInputFile(String pathToFile) {
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static FractionalTree createFractionalTree(String line) {
        int startNumerator = Integer.parseInt(line.substring(0, line.indexOf(" ")));
        int startDenominator = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
        return new FractionalTree(startNumerator, startDenominator);
    }
}
