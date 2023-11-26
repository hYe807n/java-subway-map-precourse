package subway.domain;

import static subway.domain.InitializerTest.initializeTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StationRepositoryTest {

    @BeforeEach
    void initialize() {
        initializeTest();
    }

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
        LineRepository.addSections("1호선", "1", "교대역");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            StationRepository.deleteStation("교대역"));
    }

    @DisplayName("역 삭제 기능")
    @Test
    void deleteStation() {
        Station station = new Station("압구정역");
        StationRepository.addStation(station);
        StationRepository.deleteStation("압구정역");
        Assertions.assertFalse(StationRepository.stations().contains(station));
    }

    @DisplayName("\"잠실역\" 역 검색하여 개체 반환하는 기능")
    @Test
    void searchStationByName() {
        Station station = new Station("서울대입구역");
        StationRepository.addStation(station);
        Assertions.assertEquals(StationRepository.searchStation("서울대입구역"), station);
    }

    @DisplayName("\"잠실역\" 역 검색하여 없다면 null 반환하는 기능")
    @Test
    void searchStationByNameNull() {
        Station station = new Station("잠실나루역");
        StationRepository.addStation(station);
        Assertions.assertNull(StationRepository.searchStation("강변역"));
    }
}