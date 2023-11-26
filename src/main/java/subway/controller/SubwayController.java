package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.LineForm;
import subway.enums.MainForm;
import subway.enums.SectionForm;
import subway.enums.StationForm;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    public void run() {
        initializeInform();
        String userAnswer;
        do {
            userAnswer = iterateMain();
        } while (!userAnswer.trim().equals("Q"));
    }

    private String iterateMain() {
        String userAnswer = "";
        try {
            userAnswer = mainScreen();
            checkValidMainAnswer(userAnswer);
            return userAnswer;
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception.getMessage());
        }
        return userAnswer;
    }

    private void checkValidMainAnswer(String answer) {
        if (!(answer.equals(MainForm.CHOOSE_STATION.getMessage()) ||
            answer.equals(MainForm.CHOOSE_LINE.getMessage()) ||
            answer.equals(MainForm.CHOOSE_SECTION.getMessage()) ||
            answer.equals(MainForm.CHOOSE_PRINT_SECTIONS.getMessage()) ||
            answer.equals(MainForm.EXIT.getMessage()))) {
            throw new IllegalArgumentException(MainForm.ERROR_CHOOSE.getMessage());
        }
    }

    private void checkValidSectionAnswer(String answer) {
        if (!(answer.equals(MainForm.CHOOSE_STATION.getMessage()) ||
            answer.equals(MainForm.CHOOSE_LINE.getMessage()) ||
            answer.equals(MainForm.EXIT.getMessage()))) {
            throw new IllegalArgumentException(MainForm.ERROR_CHOOSE.getMessage());
        }
    }

    private void checkValidStationLineAnswer(String answer) {
        if (!(answer.equals(StationForm.CHOOSE_ADD.getMessage()) ||
            answer.equals(StationForm.CHOOSE_DELETE.getMessage()) ||
            answer.equals(StationForm.CHOOSE_VIEW.getMessage()) ||
            answer.equals(StationForm.EXIT.getMessage()))) {
            throw new IllegalArgumentException(MainForm.ERROR_CHOOSE.getMessage());
        }
    }

    private String mainScreen() {
        String answer = InputView.readFeature(MainForm.CHOOSE_MAIN.getMessage());
        if (answer.equals(MainForm.CHOOSE_STATION.getMessage())) {
            manageStation();
        }
        if (answer.equals(MainForm.CHOOSE_LINE.getMessage())) {
            manageLine();
        }
        if (answer.equals(MainForm.CHOOSE_SECTION.getMessage())) {
            manageSection();
        }
        if (answer.equals(MainForm.CHOOSE_PRINT_SECTIONS.getMessage())) {
            printAllLines();
        }
        return answer;
    }

    private void manageSection() {
        String answer = InputView.readFeature(MainForm.CHOOSE_SECTION.getMessage());
        if (answer.equals(SectionForm.CHOOSE_ADD.getMessage())) {
            addSection();
        }
        if (answer.equals(SectionForm.CHOOSE_DELETE.getMessage())) {
            deleteSection();
        }
        checkValidSectionAnswer(answer);
    }

    private void deleteSection() {
        Line line = LineRepository.searchLine(InputView.readDeleteSectionLine());
        Station station = StationRepository.searchStation(InputView.readDeleteSectionStation());
        line.deleteSection(station);
        OutputView.printDeleteSectionSuccess();
    }

    private void addSection() {
        String line = InputView.readAddSectionLine();
        String station = InputView.readAddSectionStation();
        String sequence = InputView.readAddSectionSequence();
        LineRepository.addSections(line, sequence, station);
        OutputView.printAddSectionSuccess();
    }

    private void printAllLines() {
        LineRepository.lines().forEach(OutputView::printAllLines);
    }

    private void manageLine() {
        String answer = InputView.readFeature(MainForm.CHOOSE_LINE.getMessage());
        checkValidStationLineAnswer(answer);
        if (answer.equals(LineForm.CHOOSE_ADD.getMessage())) {
            addLine();
        }
        if (answer.equals(LineForm.CHOOSE_DELETE.getMessage())) {
            deleteLine();
        }
        if (answer.equals(LineForm.CHOOSE_VIEW.getMessage())) {
            viewLines();
        }
    }

    private void viewLines() {
        OutputView.printLines();
        LineRepository.lines().forEach(line -> OutputView.printLine(line.getName()));
    }

    private void deleteLine() {
        LineRepository.deleteLineByName(InputView.readDeleteLine());
        OutputView.printLineDeleteSuccess();
    }

    private void addLine() {
        Line line = new Line(InputView.readAddLine());
        line.addStations(InputView.readFirst());
        line.addStations(InputView.readLast());
        LineRepository.addLine(line);
        OutputView.printLineAddSucess();
    }

    private void manageStation() {
        String answer = InputView.readFeature(MainForm.CHOOSE_STATION.getMessage());
        checkValidStationLineAnswer(answer);
        if (answer.equals(StationForm.CHOOSE_ADD.getMessage())) {
            addStation();
        }
        if (answer.equals(StationForm.CHOOSE_DELETE.getMessage())) {
            deleteStation();
        }
        if (answer.equals(StationForm.CHOOSE_VIEW.getMessage())) {
            viewStation();
        }
    }

    private void viewStation() {
        OutputView.printStations();
        StationRepository.stations()
            .forEach(station -> OutputView.printStation(station.getName()));
    }

    private void addStation() {
        StationRepository.addStation(new Station(InputView.readAddStation()));
        OutputView.printStationAddSucess();
    }

    private void deleteStation() {
        StationRepository.deleteStation(InputView.readDeleteStation());
        OutputView.printStationDeleteSuccess();
    }

    private void initializeInform() {
        initializeStation();
        initializeLine();
        initializeSection();
    }

    private void initializeStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    private void initializeLine() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private void initializeSection() {
        LineRepository.searchLine("2호선").addStations("교대역");
        LineRepository.searchLine("2호선").addStations("강남역");
        LineRepository.searchLine("2호선").addStations("역삼역");
        LineRepository.searchLine("3호선").addStations("교대역");
        LineRepository.searchLine("3호선").addStations("남부터미널역");
        LineRepository.searchLine("3호선").addStations("양재역");
        LineRepository.searchLine("3호선").addStations("매봉역");
        LineRepository.searchLine("신분당선").addStations("강남역");
        LineRepository.searchLine("신분당선").addStations("양재역");
        LineRepository.searchLine("신분당선").addStations("양재시민의숲역");
    }
}
