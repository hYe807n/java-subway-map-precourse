package subway.view;

import java.util.Scanner;
import subway.enums.MainForm;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readFeature(String state) {
        OutputView.printInform(state);
        System.out.println(MainForm.USER_FEATURE.getMessage());
        return scanner.nextLine().trim();
    }

    public static String readAddStation() {
        OutputView.printStationAdd();
        return scanner.nextLine().trim();
    }

    public static String readDeleteStation() {
        OutputView.printStationDelete();
        return scanner.nextLine().trim();
    }

    public static String readAddLine() {
        OutputView.printLineAdd();
        return scanner.nextLine().trim();
    }

    public static String readFirst() {
        OutputView.printFirst();
        return scanner.nextLine().trim();
    }

    public static String readLast() {
        OutputView.printLast();
        return scanner.nextLine().trim();
    }

    public static String readDeleteLine() {
        OutputView.printLineDelete();
        return scanner.nextLine().trim();
    }

    public static String readAddSectionLine() {
        OutputView.printAddSectionLine();
        return scanner.nextLine().trim();
    }

    public static String readAddSectionStation() {
        OutputView.printAddSectionStation();
        return scanner.nextLine().trim();
    }

    public static String readAddSectionSequence() {
        OutputView.printAddSectionSequence();
        return scanner.nextLine().trim();
    }

    public static String readDeleteSectionLine() {
        OutputView.printDeleteSectionLine();
        return scanner.nextLine().trim();
    }

    public static String readDeleteSectionStation() {
        OutputView.printDeleteSectionStation();
        return scanner.nextLine().trim();
    }
}
