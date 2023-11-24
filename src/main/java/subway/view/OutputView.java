package subway.view;

import java.util.StringJoiner;
import subway.domain.Line;
import subway.enums.LineForm;
import subway.enums.MainForm;
import subway.enums.StationForm;

public class OutputView {

    public static void printMain() {
        System.out.println(MainForm.MAIN_MASSAGE.getMessage());
    }

    public static void printStationManage() {
        System.out.println(StationForm.MAIN_STATION_MESSAGE.getMessage());
    }

    public static void printStationAdd() {
        System.out.println(StationForm.STATION_ADD.getMessage());
    }

    public static void printStationDelete() {
        System.out.println(StationForm.STATION_DELETE.getMessage());
    }

    public static void printStationAddSucess() {
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), StationForm.STATION_ADD_SUCCESS.getMessage()));
    }

    public static void printStationDeleteSuccess() {
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), StationForm.STATION_DELETE_SUCCESS.getMessage()));
    }

    public static void printError(String message) {
        System.out.println(new StringJoiner("", MainForm.INFO_ERROR.getMessage(), message));
    }

    public static void printStations() {
        System.out.println(StationForm.STATIONS.getMessage());
    }

    public static void printStation(String station) {
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), station));
    }

    public static void printLineManage() {
        System.out.println(LineForm.MAIN_LINE_MESSAGE.getMessage());
    }

    public static void printLineAdd() {
        System.out.println(LineForm.LINE_ADD.getMessage());
    }

    public static void printFirst() {
        System.out.println(LineForm.LINE_FIRST.getMessage());
    }

    public static void printLast() {
        System.out.println(LineForm.LINE_LAST.getMessage());
    }

    public static void printLineDelete() {
        System.out.println(LineForm.LINE_DELETE.getMessage());
    }

    public static void printLineDeleteSuccess() {
        System.out.println(LineForm.STATION_DELETE_SUCCESS);
    }

    public static void printLines() {
        System.out.println(LineForm.LINES.getMessage());
    }

    public static void printLine(String line) {
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), line));
    }
}
