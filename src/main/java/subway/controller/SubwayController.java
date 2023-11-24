package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.LineForm;
import subway.enums.MainForm;
import subway.enums.StationForm;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    public void run() {
        initializeInform();
        String userAnswer = "";
        do {
            try {
                userAnswer = mainScreen();
            } catch (IllegalArgumentException exception) {
                OutputView.printError(exception.getMessage());
            }
        } while(!userAnswer.trim().equals("Q"));
    }

    private String mainScreen() {
        OutputView.printMain();
        String answer = InputView.readUserFeature();
        if (answer.equals(MainForm.CHOOSE_STATION.getMessage())) {
            manageStation();
        }
        if (answer.equals(MainForm.CHOOSE_LINE.getMessage())) {
            manageLine();
        }
        if (answer.equals(MainForm.CHOOSE_PRINT_SECTIONS.getMessage())) {
            printAllLines();
        }
        return answer;
    }

    private void printAllLines() {
        LineRepository.lines().forEach(OutputView::printAllLines);
    }

    private void manageLine() {
        OutputView.printLineManage();
        String answer = InputView.readUserFeature();
        if (answer.equals(LineForm.CHOOSE_ADD.getMessage())) {
            addLine();
        }
        if (answer.equals(LineForm.CHOOSE_DELETE.getMessage())) {
            deleteLine();
        }
        if (answer.equals(LineForm.CHOOSE_VIEW.getMessage())) {
            OutputView.printLines();
            StationRepository.stations().forEach(line -> OutputView.printLine(line.getName()));
            return;
        }
        if (answer.equals(LineForm.EXIT.getMessage())) {
            manageLine();
            return;
        }
        throw new IllegalArgumentException("1, 2, 3, B 중에 입력해주세요.");
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
        OutputView.printStationAddSucess();
    }

    private void manageStation() {
        OutputView.printStationManage();
        String answer = InputView.readUserFeature();
        if (answer.equals(StationForm.CHOOSE_ADD.getMessage())) {
            addStation();
            return;
        }
        if (answer.equals(StationForm.CHOOSE_DELETE.getMessage())) {
            deleteStation();
            return;
        }
        if (answer.equals(StationForm.CHOOSE_VIEW.getMessage())) {
            OutputView.printStations();
            StationRepository.stations().forEach(station -> OutputView.printStation(station.getName()));
            return;
        }
        if (answer.equals(StationForm.EXIT.getMessage())) {
            manageStation();
            return;
        }
        throw new IllegalArgumentException("1, 2, 3, B 중에 입력해주세요.");
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
        LineRepository.searchLine("3호선").addStations("남부터미널역");
        LineRepository.searchLine("3호선").addStations("양재역");
        LineRepository.searchLine("3호선").addStations("매봉역");
        LineRepository.searchLine("신분당선").addStations("양재시민의숲역");
    }
}
