package cz.vendasky;

import java.io.*;

public class FractionalTree {

    private Fraction actualFraction;
    private String path;

    private FractionalTree(long startNumerator, long startDenominator) {
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
        long startNumerator = Long.parseLong(line.substring(0, line.indexOf(" ")));
        long startDenominator = Long.parseLong(line.substring(line.indexOf(" ") + 1));
        return new FractionalTree(startNumerator, startDenominator);
    }

    public static void run(String pathToInputFile, String pathToOutputFile) {
        String line = readFromInputFile(pathToInputFile);
        FractionalTree fractionalTree = createFractionalTree(line);
        fractionalTree.findPathToRoot();
        try {
            PrintWriter writer = new PrintWriter(pathToOutputFile, "UTF-8");
            writer.println(fractionalTree.getPath());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
