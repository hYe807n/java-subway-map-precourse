package subway.view;

import java.util.Scanner;
import subway.enums.Form;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readUserFeature() {
        System.out.println(Form.USER_FEATURE.getMessage());
        return scanner.nextLine().trim();
    }
}
