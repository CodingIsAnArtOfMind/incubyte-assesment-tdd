package main;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        }
        else if (numbers.contains(",")) {
            String[] numToken = numbers.split(",");
            return Integer.parseInt(numToken[0]) + Integer.parseInt(numToken[1]);
        }
        return Integer.parseInt(numbers);
    }
}