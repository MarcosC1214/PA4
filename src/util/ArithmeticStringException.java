package util;

// Custom exception class for Arithmetic String patterns.
public class ArithmeticStringException extends Exception {
    private String arithmeticString;
    private int occurrenceIndex;
    private int order;

    @Override
    public String getMessage() {
        return "An arithmetic string (" + (order > 0 ? "ascending" : "descending") + ") " +
                arithmeticString + " is found at index " + occurrenceIndex + "!";
    }

    public ArithmeticStringException(String arithmeticString, int index, int order) {
        this.arithmeticString = arithmeticString;
        occurrenceIndex = index;
        this.order = order;
    }
}