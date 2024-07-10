import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings_Homework {
    public static void main(String[] args) {

//        reverseStrings();
//        repeatStrings();
//        substring();
//        textFilter();
//        digitsLettersAndOther();
//        validUsernames();
//        extractFile();
//        caesarCipher();
//        multiplyBigNumber(); // TO DO
//        replaceRepeatingChars();
//        extractPersonInformation();
//        asciiSumator();
//        morseCodeTranslator();
//        html();
//        letter();
//        matchFullName();
//        matchPhoneNumber();
//        pascalCaseSplitter();
//        matchDates();
//        starBattlesEnigma();
    }

    public static void reverseStrings() {
        Scanner sc = new Scanner(System.in);

        String input = "";

        while (!(input = sc.nextLine()).equals("end")) {
            System.out.print(input + " = ");

            for (int ch = input.length() - 1; ch >= 0 ; ch--) {
                System.out.print(input.charAt(ch));
            }
            System.out.println();
        }
    }

    public static void repeatStrings() {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");
        String result = "";

        for (String str : arr) {
            for (int j = 0; j < str.length(); j++) {
                result = result.concat(str);
            }
        }
        System.out.println(result);
    }

    public static void substring() {
        Scanner sc = new Scanner(System.in);

        String substring = sc.nextLine();
        String str = sc.nextLine();

        while (str.contains(substring)) {
            str = str.replace(substring, "");
        }
        System.out.println(str);
    }

    public static void textFilter() {
        Scanner sc = new Scanner(System.in);

        String[] stringsToReplace = sc.nextLine().split("[, ]+");
        String result = "";

        String text = "";

        while (!(text = sc.nextLine()).isEmpty()) {

            for (String s : stringsToReplace) {
                text = text.replaceAll(s, "*".repeat(s.length()));
            }
            System.out.println(text);
        }
    }

    public static void digitsLettersAndOther() {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        StringBuilder chars = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();


        for (int ch = 0; ch < text.length(); ch++) {
            if (Character.isDigit(text.charAt(ch))) {
                chars.append(text.charAt(ch));
            } else if (Character.isLetter(text.charAt(ch))) {
                letters.append(text.charAt(ch));
            } else {
                other.append(text.charAt(ch));
            }
        }
        System.out.println(chars);
        System.out.println(letters);
        System.out.println(other);
    }

    public static void validUsernames() {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");

        for (String username : input) {
            if (username.length() >= 3 && username.length() <= 16) {
                boolean isValid = true;

                for (int j = 0; j < username.length(); j++) {
                    if (!Character.isLetter(username.charAt(j)) &&
                            !Character.isDigit(username.charAt(j)) &&
                            username.charAt(j) != '-' &&
                            username.charAt(j) != '_') {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    System.out.println(username);
                }
            }
        }
    }

    public static void extractFile() {
        Scanner sc = new Scanner(System.in);

        String[] path = sc.nextLine().split("\\\\");
        int index = path[path.length- 1].lastIndexOf(".");
        String file = path[path.length- 1].substring(0, index);
        String extension = path[path.length- 1].substring(index);

        System.out.println("FIle name: " + file);
        System.out.println("FIle extension: " + extension);
    }

    public static void caesarCipher() {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        StringBuilder result = new StringBuilder();

        for (int ch = 0; ch < text.length(); ch++) {
            char letter = text.charAt(ch);
            letter += 3;
            result.append(letter);
        }

        System.out.println(result);
    }

    public static void multiplyBigNumber() {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int digit = Integer.parseInt(sc.nextLine());

        StringBuilder result = new StringBuilder();

        int temp = 0;
        for (int i = 0; i < num.length(); i++) {
            int mult = Character.getNumericValue(num.charAt(num.length() - i - 1)) * digit;
            mult += temp;

            if (mult > 9) {
                temp = mult / 10;
                mult %= 10;
            } else if (temp != 0) {
                temp = 0;
            }
            result.append(mult);
        }

        if (temp != 0) {
            result.append(temp);
        }
        for (int i = 0; i < result.length(); i++) {
            System.out.print(result.charAt(result.length() - i - 1));
        }
    }

    public static void replaceRepeatingChars() {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        StringBuilder result = new StringBuilder();
        char ch = ' ';

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ch) {
                ch = text.charAt(i);
                result.append(ch);
            }
        }
        System.out.println(result);
    }

    public static void extractPersonInformation() {
        Scanner sc = new Scanner(System.in);

        int entries = Integer.parseInt(sc.nextLine());
        int startIndexName = -1;
        int endIndexName = -1;
        int startIndexAge = -1;
        int endIndexAge = -1;

        for (int entry = 0; entry < entries; entry++) {
            String input = sc.nextLine();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '@') {
                    startIndexName = i + 1;
                } else if (input.charAt(i) == '|') {
                    endIndexName = i;
                } else if (input.charAt(i) == '#') {
                    startIndexAge = i + 1;
                } else if (input.charAt(i) == '*') {
                    endIndexAge = i;
                }
            }

            String name = input.substring(startIndexName, endIndexName);
            String age = input.substring(startIndexAge, endIndexAge);

            System.out.println(name + " is " + age + " years old.");
        }
    }

    public static void asciiSumator() {
        Scanner sc = new Scanner(System.in);


    }

    public static void morseCodeTranslator() {
        Scanner sc = new Scanner(System.in);
        String[] morse = sc.nextLine().split(" ");

        Map<String, Character> morseAlphabet = new HashMap<>();

        morseAlphabet.put(".-", 'A'); morseAlphabet.put("-.", 'N');
        morseAlphabet.put("-...", 'B'); morseAlphabet.put("---", 'O');
        morseAlphabet.put("-.-.", 'C'); morseAlphabet.put(".--.", 'P');
        morseAlphabet.put("-..", 'D'); morseAlphabet.put("--.-", 'Q');
        morseAlphabet.put(".", 'E'); morseAlphabet.put(".-.", 'R');
        morseAlphabet.put("..-.", 'F'); morseAlphabet.put("...", 'S');
        morseAlphabet.put("--.", 'G'); morseAlphabet.put("-", 'T');
        morseAlphabet.put("....", 'H'); morseAlphabet.put("..-", 'U');
        morseAlphabet.put("..", 'I'); morseAlphabet.put("...-", 'V');
        morseAlphabet.put(".---", 'J'); morseAlphabet.put(".--", 'W');
        morseAlphabet.put("-.-", 'K'); morseAlphabet.put("-..-", 'X');
        morseAlphabet.put(".-..", 'L'); morseAlphabet.put("-.--", 'Y');
        morseAlphabet.put("--", 'M'); morseAlphabet.put("--..", 'Z');

        for (String symbol : morse) {
            if (symbol.equals("|")) {
                System.out.print(" ");
            } else {
                System.out.print(morseAlphabet.get(symbol));
            }
        }
    }

    public static void html() {
        Scanner sc = new Scanner(System.in);

        String title = sc.nextLine();
        String content = sc.nextLine();

        System.out.println("<h1>");
        System.out.println("  " + title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println("  " + content);
        System.out.println("</article>");

        String comment = " ";
        while (!(comment = sc.nextLine()).equals("end of comments")) {
            System.out.println("<div>");
            System.out.println("  " + comment);
            System.out.println("</div>");
        }
    }

    public static void letter() {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String[] replacements = text.split("[^_]");
        String[] words = sc.nextLine().split("[ ,\\[\\]']+");

        for (String replace : replacements) {
            for (String word : words) {
                if (word.length() == replace.length()) {
                    text = text.replaceFirst(replace, word);
                    break;
                }
            }
        }

        text = text.replace("\\", "");
        text = text.substring(1, text.length() - 2);

        System.out.println(text);
    }

    public static void matchFullName() {
        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().split(", ");

        for (String name : names) {

            if (name.matches("\\b^[A-Z][a-z]+ [A-Z][a-z]+$\\b")) {
                System.out.print(name + " ");
            }
        }
    }

    public static void matchPhoneNumber() {
        Scanner sc = new Scanner(System.in);

        String phones = sc.nextLine();

        Pattern pattern = Pattern.compile("\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = pattern.matcher(phones);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void pascalCaseSplitter() {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Pattern pattern = Pattern.compile("[A-z][a-z]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void matchDates() {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Pattern pattern = Pattern.compile("(?<day>\\d{2})([-.\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print("Day: " + matcher.group("day"));
            System.out.print(", Month: " + matcher.group("month"));
            System.out.print(", Year: " + matcher.group("year"));
            System.out.println();
        }
    }

    public static void starBattlesEnigma() {
        Scanner sc = new Scanner(System.in);

        int entries = Integer.parseInt(sc.nextLine());
        Map<Character, List<String>> result = new HashMap<>();

        for (int entry = 0; entry < entries; entry++) {
            String input = sc.nextLine();

            int cntr = 0;
            for (int letter = 0; letter < input.length(); letter++) {
                if(Character.toLowerCase(input.charAt(letter)) == 's' ||
                        Character.toLowerCase(input.charAt(letter)) == 't' ||
                        Character.toLowerCase(input.charAt(letter)) == 'a' ||
                        Character.toLowerCase(input.charAt(letter)) == 'r') {

                    cntr++;
                }
            }

            char letter;
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                letter = input.charAt(i);
                letter -= cntr;
                decrypted.append(letter);
            }

            Pattern pattern = Pattern.compile("@.*?(?=[A-Z])(?<planet>[A-Z][a-z]+).*?(?=:):(?<population>\\d+)!(?<attacktype>[A|D])!->(?<soldiercount>\\d+)");
            Matcher matcher = pattern.matcher(decrypted);

            while (matcher.find()) {
                char type = matcher.group("attacktype").equals("A") ? 'A' : 'B';

                result.putIfAbsent(type, new ArrayList<>());
                result.get(type).add(matcher.group("planet"));
            }
        }

        char[] types = {'A', 'B'};
        String[] comments = {"Attacked planets: ", "Destroyed planets: "};
        for (int i = 0; i < 2; i++) {
            List<String> planets = result.get(types[i]);

            if (planets == null) {
                System.out.println(comments[i] + '0');
            } else {
                System.out.println(comments[i] + planets.size());
                for (String planet : planets) {
                    System.out.println("-> " + planet);
                }
            }
        }
    }
}