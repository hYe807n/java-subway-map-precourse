package subway.domain;

import static org.junit.jupiter.api.Assertions.*;
import static subway.domain.InitializerTest.initializeTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StationTest {

    @BeforeEach
    void initialize() {
        initializeTest();
    }

    @DisplayName("역 이름 중복 시 예외 처리")
    @Test
    void addStationByDuplicateName() {
        StationRepository.addStation(new Station("구의역"));
        assertThrows(IllegalArgumentException.class, () ->
            StationRepository.addStation(new Station("구의역")));
    }

    @DisplayName("역 이름 2글자 이상이 아니라면 예외 처리")
    @Test
    void addLineByMinimumName() {
        assertThrows(IllegalArgumentException.class, () ->
            StationRepository.addStation(new Station("2")));
    }

    @DisplayName("역이 노선에 포함되어 있다면 true 반환")
    @Test
    void stationContainsLine() {
        LineRepository.addSections("2호선", "1", "합정역");
        Assertions.assertTrue(StationRepository.searchStation("합정역").isLine());
    }

    @DisplayName("역이 노선에 포함되어 있지 않다면 false 반환")
    @Test
    void stationNotContainsLine() {
        StationRepository.addStation(new Station("이대역"));
        Assertions.assertFalse(StationRepository.searchStation("이대역").isLine());
    }
}