package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayController {

    public void run() {
        initializeInform();
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
