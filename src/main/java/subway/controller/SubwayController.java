package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.enums.MainForm;
import subway.enums.StationForm;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    public void run() {
        initializeInform();
        String userAnswer = "";
        do {
            userAnswer = mainScreen();
        } while(userAnswer.trim().equals("Q"));
    }

    private String mainScreen() {
        OutputView.printMain();
        String answer = InputView.readUserFeature();
        if (answer.equals(MainForm.CHOOSE_STATION.getMessage())) {
            manageStation();
            return answer;
        }
        return answer;
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
