package org.example.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> inputNumbers = new ArrayList<>();
        inputNumbers.addAll(Arrays.asList(3, 1, 31, 31, 31, 31, 9, 0, 4, 5, 7, 33, 4));
        System.out.println("Arrays has two items that makes sum of 4: " + hasSum(4, inputNumbers));
    }

    public static boolean hasSum(int sum, List<Integer> input) {
        //implement logic
        return false;
    }
}
