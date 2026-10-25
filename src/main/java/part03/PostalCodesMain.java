package part03;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class PostalCodesMain {

    public static void main(String[] args) {
        Map<String, String> postalCodes = PostalCodesReader.readPostalCodes();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input postal code or district (e.g., 00100 or Helsinki): ");
        String answer = scanner.nextLine();

        if (postalCodes.containsKey(answer)) {
            System.out.println(postalCodes.get(answer));
        } else {
            TreeSet<String> codes = new TreeSet<>();

            for (Map.Entry<String, String> entry : postalCodes.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(answer)) {
                    codes.add(entry.getKey());
                }
            }

            for (String code : codes) {
                System.out.println(code);
            }
        }

        scanner.close();
    }
}
