package main;

import java.util.Arrays;
import java.util.List;


public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        }
        else if (numbers.contains(",")) {
            String[] numToken = numbers.split("[,\n]");
            List<Integer> numList = Arrays.stream(numToken).map(StringCalculator::getAllInteger).toList();
            return numList.stream().mapToInt(Integer::intValue).sum();
        }
        return Integer.parseInt(numbers);
    }
    private static int getAllInteger(String num) {
        return Integer.parseInt(num);
    }
}