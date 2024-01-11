package main;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        }
        else {
            String[] numToken = getCustomDelimeterString(numbers);
            List<Integer> numList = Arrays.stream(numToken).map(StringCalculator::getAllInteger).toList();
            validateNegativeNumbers(numList);
            return numList.stream().mapToInt(Integer::intValue).sum();
        }
    }

    private static void validateNegativeNumbers(List<Integer> numList) {
        List<Integer> negativeNumList = numList.stream().filter(i -> i < 0).toList();
        if (!negativeNumList.isEmpty()) {
            throw new RuntimeException("Negatives not allowed: " +
                    negativeNumList.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }
    }

    private static String[] getCustomDelimeterString(String numbers) {
        if (isStartWith(numbers)) {
            Pattern pattern= Pattern.compile("//(.*)\n(.*)");
            Matcher matcher = pattern.matcher(numbers);
            matcher.matches();
            String deliCustom = matcher.group(1);
            numbers = matcher.group(2);
            return numbers.split(Pattern.quote(deliCustom));
        }
        return numbers.split("[,\n]");
    }

    private static boolean isStartWith(String numbers) {
        return numbers.startsWith("//");
    }

    private static int getAllInteger(String num) {
        return Integer.parseInt(num);
    }
}