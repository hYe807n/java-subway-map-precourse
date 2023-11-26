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
}