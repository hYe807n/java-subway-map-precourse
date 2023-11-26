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
}