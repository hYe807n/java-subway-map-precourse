package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static subway.domain.InitializerTest.initializeTest;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @BeforeEach
    void initialize() {
        initializeTest();
    }

    @DisplayName("2호선에 잠실역 추가")
    @Test
    void addStationsInLine() {
        Line line = new Line("2호선");
        line.addStations("잠실역");
        assertThat(line.getStations().stream().findFirst().map(Station::getName)).contains("잠실역");
    }

    @DisplayName("노선 이름 중복 시 예외 처리")
    @Test
    void addLineByDuplicateName() {
        LineRepository.addLine(new Line("5호선"));
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () ->
            LineRepository.addLine(new Line("5호선")));
    }

    @DisplayName("노선 이름 2글자 이상이 아니라면 예외 처리")
    @Test
    void addLineByMinimumName() {
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () ->
            LineRepository.addLine(new Line("2")));
    }

    @DisplayName("노선에 포함된 역이 2 개 이하일 때, 구간 삭제 시 예외 처리")
    @Test
    void exceptDeleteSectionBySize() {
        Line line = new Line("8호선");
        line.addStations("교대역");
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> line.deleteSection(StationRepository.searchStation("교대역")));
    }

    @DisplayName("노선에 포함된 구간 삭제")
    @Test
    void deleteSection() {
        Line line = new Line("1호선");
        line.addStations("신림역");
        line.addStations("왕십리역");
        line.addStations("건대역");
        line.deleteSection(StationRepository.searchStation("건대역"));
        assertThat(line.getStations().stream().map(Station::getName)).containsAll(Arrays.asList("신림역", "왕십리역"));
    }
}