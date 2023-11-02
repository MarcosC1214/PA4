package util;

// Custom exception class for Balanced Bipartite patterns.
public class BalancedBipartiteException extends Exception {
    private String balancedBipartiteString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return "A balanced bipartite string " + balancedBipartiteString + " is found at index " + occurrenceIndex + "!";
    }

    public BalancedBipartiteException(String balancedBipartiteString, int index) {
        this.balancedBipartiteString = balancedBipartiteString;
        occurrenceIndex = index;
    }
}
