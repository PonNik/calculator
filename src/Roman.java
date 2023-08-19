import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

enum Roman {
    I(1), IV(4), V(5), IX(9), X(10);
    private final int value;

    Roman(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<Roman> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((Roman e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

    public static int parseInt(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<Roman> romanNumerals = Roman.getReverseSortedValues();

        int i = 0;

        while ((!romanNumeral.isEmpty()) && (i < romanNumerals.size())) {
            Roman symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (!romanNumeral.isEmpty()) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public static String parseStr(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<Roman> romanNumerals = Roman.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            Roman currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
