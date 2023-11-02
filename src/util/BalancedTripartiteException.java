package util;

// Custom exception class for Balanced Tripartite patterns.
public class BalancedTripartiteException extends Exception {
    private String balancedTripartiteString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return "A balanced tripartite string " + balancedTripartiteString + " is found at index " + occurrenceIndex + "!";
    }

    public BalancedTripartiteException(String balancedTripartiteString, int index) {
        this.balancedTripartiteString = balancedTripartiteString;
        occurrenceIndex = index;
    }
}
