package util;

// Custom exception class for Palindrome patterns.
public class PalindromeException extends Exception {
    private String palindromeString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return "A palindrome string " + palindromeString + " is found at index " + occurrenceIndex + "!";
    }

    public PalindromeException(String palindromeString, int index) {
        this.palindromeString = palindromeString;
        occurrenceIndex = index;
    }
}
