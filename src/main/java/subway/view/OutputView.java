package subway.view;

import java.util.StringJoiner;
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
}
