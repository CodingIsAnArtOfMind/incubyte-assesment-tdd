package main;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        }
        else {
            String[] numToken = getCustomDelimeterString(numbers);
            List<Integer> numList = Arrays.stream(numToken).map(StringCalculator::getAllInteger).toList();
            if (numList.stream().anyMatch(i -> i < 0)) {
                throw new RuntimeException("negatives not allowed");
            }
            return numList.stream().mapToInt(Integer::intValue).sum();
        }
    }

    private static String[] getCustomDelimeterString(String numbers) {
        if (numbers.startsWith("//")) {
            Pattern pattern= Pattern.compile("//(.*)\n(.*)");
            Matcher matcher = pattern.matcher(numbers);
            matcher.matches();
            String deliCustom = matcher.group(1);
            numbers = matcher.group(2);
            return numbers.split(Pattern.quote(deliCustom));
        }
        return numbers.split("[,\n]");
    }

    private static int getAllInteger(String num) {
        return Integer.parseInt(num);
    }
}