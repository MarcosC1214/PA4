package main;

import util.*;
import java.util.*;

public class PatternFinder {
    // Generate a random string of given length.
    private static String randomStringGenerator(int length) {
        Random random = new Random(System.nanoTime());
        char[] array = new char[length];
        for (int i = 0; i < length; i++)
            array[i] = (char) ('a' + random.nextInt(26));
        return new String(array);
    }

    // Find and throw an exception if a singleton pattern is found in the input string.
    private static void singletonMiner(String mine, int length) throws SingletonException {
        for (int start = 0; start <= mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++) {
                if (mine.charAt(i) != mine.charAt(i - 1))
                    break;
            }
            if (i == start + length)
                throw new SingletonException(mine.substring(start, start + length), start);
        }
    }

    // Find and throw an exception if an arithmetic pattern of the given order is found in the input string.
    private static void arithmeticStringMiner(String mine, int length, int order) throws ArithmeticStringException {
        for (int start = 0; start <= mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++) {
                if (order > 0 && mine.charAt(i) != mine.charAt(i - 1) + 1)
                    break;
                else if (order < 0 && mine.charAt(i) != mine.charAt(i - 1) - 1)
                    break;
            }
            if (i == start + length)
                throw new ArithmeticStringException(mine.substring(start, start + length), start, order);
        }
    }

    // Find and throw an exception if a balanced tripartite pattern is found in the input string.
    private static void balancedTripartiteMiner(String mine, int length) throws BalancedTripartiteException {
        int partLength = mine.length() / 3;
        for (int start = 0; start <= mine.length() - length; start++) {
            if (start + 3 * partLength <= mine.length() &&
                    (mine.substring(start, start + partLength).equals(mine.substring(start + partLength, start + 2 * partLength))
                            && mine.substring(start + partLength, start + 2 * partLength).equals(mine.substring(start + 2 * partLength, start + 3 * partLength)))) {
                throw new BalancedTripartiteException(mine.substring(start, start + length), start);
            }
        }
    }

    // Find and throw an exception if a balanced bipartite pattern is found in the input string.
    private static void balancedBipartiteMiner(String mine, int length) throws BalancedBipartiteException {
        int halfLength = mine.length() / 2;
        for (int start = 0; start <= mine.length() - length; start++) {
            if (start + halfLength + length <= mine.length() &&
                    mine.substring(start, start + halfLength).equals(mine.substring(start + halfLength, start + halfLength + length))) {
                throw new BalancedBipartiteException(mine.substring(start, start + length), start);
            }
        }
    }

    // Find and throw an exception if a palindrome pattern is found in the input string.
    private static void palindromeMiner(String mine, int length) throws PalindromeException {
        for (int start = 0; start <= mine.length() - length; start++) {
            String substring = mine.substring(start, start + length);
            if (isPalindrome(substring)) {
                throw new PalindromeException(substring, start);
            }
        }
    }

    // Check if a given string is a palindrome.
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the length of random string: ");
        int randomStringLength = keyboard.nextInt();

        System.out.println("Enter the maximum pattern length: ");
        int patternMaxLength = keyboard.nextInt();

        while (true) {
            try {
                if (randomStringLength < 100000 || randomStringLength > 1000000000 || patternMaxLength < 3 || patternMaxLength > 15)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again!");
                randomStringLength = keyboard.nextInt();
                patternMaxLength = keyboard.nextInt();
                continue;
            }
            break;
        }

        String randomString = randomStringGenerator(randomStringLength);

        for (int length = patternMaxLength; length > 0; length--) {
            try {
                singletonMiner(randomString, length);
            } catch (SingletonException se) {
                System.out.println(se.getMessage());
            }
            try {
                arithmeticStringMiner(randomString, length, 1);
            } catch (ArithmeticStringException ae) {
                System.out.println(ae.getMessage());
            }
            try {
                arithmeticStringMiner(randomString, length, -1);
            } catch (ArithmeticStringException ae) {
                System.out.println(ae.getMessage());
            }
            try {
                balancedTripartiteMiner(randomString, length);
            } catch (BalancedTripartiteException bte) {
                System.out.println(bte.getMessage());
            }
            try {
                balancedBipartiteMiner(randomString, length);
            } catch (BalancedBipartiteException bbe) {
                System.out.println(bbe.getMessage());
            }
            try {
                palindromeMiner(randomString, length);
            } catch (PalindromeException pe) {
                System.out.println(pe.getMessage());
            }
        }
    }
}