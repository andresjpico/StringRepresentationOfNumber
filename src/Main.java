import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Requirements: Write
        // Input int 1 to 999
        // Output string representation of english word of the input
        // ex: input 5 - output "five"

        // Convert by language
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter a language: ");
        String language = sc.nextLine();              //reads string
        System.out.print("You have entered: "+ language);

        ConvertToLanguage convertToLanguage = null;
        if (language.equals("english")) {
            convertToLanguage = new ConvertToEnglish();
        } else if (language.equals("spanish")) {
            System.out.println("Spanish not implemented");
            convertToLanguage = new ConvertToSpanish();
        } else {
            System.out.println("Language not supported");
            convertToLanguage = new ConvertToLanguage();
        }

        System.out.println();
        System.out.println(convertUnitTest(5, "five", convertToLanguage));
        System.out.println(convertUnitTest(99, "nighty nine", convertToLanguage));
        System.out.println(convertUnitTest(1000, "Not Valid", convertToLanguage));
        System.out.println(convertUnitTest(15, "fifteen", convertToLanguage));

        System.out.println();
        // Print all numbers
        for (int num = 1; num < 100; num++) {
            System.out.println(convertToLanguage.convert(num));
        }
    }

    public static boolean convertUnitTest(int number, String expected, ConvertToLanguage convertToLanguage) {
        return expected.equals(convertToLanguage.convert(number));
    }

    public static class ConvertToLanguage {
        public String convert(int num) {
            return "";
        }
    }

    public static class ConvertToEnglish extends ConvertToLanguage {
        Map<Integer, String> map;

        public ConvertToEnglish() {
            map = new HashMap<>();

            map.put(1, "one");
            map.put(2, "two");
            map.put(3, "three");
            map.put(4, "four");
            map.put(5, "five");
            map.put(6, "six");
            map.put(7, "seven");
            map.put(8, "eight");
            map.put(9, "nine");
            map.put(10, "ten");
            map.put(11, "eleven");
            map.put(12, "twelve");
            map.put(13, "thirteen");
            map.put(14, "fourteen");
            map.put(15, "fifteen");
            map.put(16, "sixteen");
            map.put(17, "seventeen");
            map.put(18, "eighteen");
            map.put(19, "nineteen");
            map.put(20, "twenty");
            map.put(30, "thirty");
            map.put(40, "forty");
            map.put(50, "fifty");
            map.put(60, "sixty");
            map.put(70, "seventy");
            map.put(80, "eighty");
            map.put(90, "nighty");
        }

        public String convert(int num) {
            if (num < 1 || num > 99) {
                return "Not Valid";
            } else if (num < 20) {
                // 1 to 19
                return map.get(num);
            } else {
                // 20 to 99
                int leftNumber = (num / 10) * 10;
                int rightNumber = num % 10;

                StringBuilder sb = new StringBuilder();
                sb.append(map.get(leftNumber));
                if (rightNumber > 0) {
                    sb.append(" ");
                    sb.append(map.get(rightNumber));
                }
                return sb.toString();
            }
        }
    }

    public static class ConvertToSpanish extends ConvertToLanguage {
        public String convert(int num) {
            return "";
        }
    }
}