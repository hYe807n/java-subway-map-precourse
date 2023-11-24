package subway.view;

import java.util.Scanner;
import subway.enums.MainForm;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readUserFeature() {
        System.out.println(MainForm.USER_FEATURE.getMessage());
        return scanner.nextLine().trim();
    }

    public static String readAddStation() {
        OutputView.printStationAdd();
        return scanner.nextLine().trim();
    }
}
