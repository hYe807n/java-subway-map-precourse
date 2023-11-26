package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StationRepositoryTest {

    @DisplayName("역 추가 기능")
    @Test
    void addStation() {
        Station station = new Station("잠실역");
        StationRepository.addStation(station);
        Assertions.assertTrue(StationRepository.stations().contains(station));
    }

    @DisplayName("노선에 등록된 역 삭제 시 예외 처리")
    @Test
    void deleteStationByContainsLine() {
        LineRepository.addSections("1호선", "1", "잠실역");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            StationRepository.deleteStation("잠실역"));
    }

    @DisplayName("역 삭제 기능")
    @Test
    void deleteStation() {
        Station station = new Station("잠실역");
        StationRepository.addStation(station);
        StationRepository.deleteStation("잠실역");
        Assertions.assertFalse(StationRepository.stations().contains(station));
    }

    @DisplayName("\"잠실역\" 역 검색하여 개체 반환하는 기능")
    @Test
    void searchStationByName() {
        Station station = new Station("잠실역");
        StationRepository.addStation(station);
        Assertions.assertEquals(StationRepository.searchStation("잠실역"), station);
    }
}