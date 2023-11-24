package subway.view;

import java.util.StringJoiner;
import subway.domain.Line;
import subway.enums.LineForm;
import subway.enums.MainForm;
import subway.enums.SectionForm;
import subway.enums.StationForm;

public class OutputView {

    public static void printStationAdd() {
        System.out.println(StationForm.STATION_ADD.getMessage());
    }

    public static void printStationDelete() {
        System.out.println(StationForm.STATION_DELETE.getMessage());
    }

    public static void printStationAddSucess() {
        System.out.println("");
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), StationForm.STATION_ADD_SUCCESS.getMessage()));
    }

    public static void printStationDeleteSuccess() {
        System.out.println("");
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

    public static void printLineAddSucess() {
        System.out.println("");
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), LineForm.STATION_ADD_SUCCESS.getMessage()));
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
        System.out.println("");
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(),LineForm.STATION_DELETE_SUCCESS.getMessage()));
    }

    public static void printLines() {
        System.out.println(LineForm.LINES.getMessage());
    }

    public static void printLine(String line) {
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), line));
    }

    public static void printAllLines(Line line) {
        System.out.println("");
        printLine(line.getName());
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), "---"));
        line.getStations().forEach(station -> printStation(station.getName()));
    }

    public static void printAddSectionLine() {
        System.out.println(SectionForm.SECTION_LINE.getMessage());
    }

    public static void printAddSectionStation() {
        System.out.println(SectionForm.SECTION_STATION.getMessage());
    }

    public static void printAddSectionSequence() {
        System.out.println(SectionForm.SECTION_SEQUENCE.getMessage());
    }

    public static void printAddSectionSuccess() {
        System.out.println("");
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), SectionForm.STATION_ADD_SUCCESS.getMessage()));
    }

    public static void printDeleteSectionLine() {
        System.out.println(SectionForm.DELETE_LINE.getMessage());
    }

    public static void printDeleteSectionStation() {
        System.out.println(SectionForm.DELETE_STATION.getMessage());
    }

    public static void printDeleteSectionSuccess() {
        System.out.println("");
        System.out.println(new StringJoiner("", MainForm.INFO_FORM.getMessage(), SectionForm.STATION_DELETE_SUCCESS.getMessage()));
    }
}
