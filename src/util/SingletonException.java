package util;

// Custom exception class for Singleton patterns.
public class SingletonException extends Exception {
    private String singletonString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return singletonString + " is a singleton string that is found at index " + occurrenceIndex + "!";
    }

    public SingletonException(String singletonString, int index) {
        this.singletonString = singletonString;
        occurrenceIndex = index;
    }
}

