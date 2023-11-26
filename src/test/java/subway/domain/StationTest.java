package subway.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StationTest {

    @DisplayName("역 이름 중복 시 예외 처리")
    @Test
    void addStationByDuplicateName() {
        StationRepository.addStation(new Station("잠실역"));
        assertThrows(IllegalArgumentException.class, () ->
            StationRepository.addStation(new Station("잠실역")));
    }

    @DisplayName("역 이름 2글자 이상이 아니라면 예외 처리")
    @Test
    void addLineByMinimumName() {
        assertThrows(IllegalArgumentException.class, () ->
            StationRepository.addStation(new Station("2")));
    }
}