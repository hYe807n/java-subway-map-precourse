package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("2호선에 잠실역 추가")
    @Test
    void addStationsInLine() {
        Line line = new Line("2호선");
        line.addStations("잠실역");
        assertThat(line.getStations().stream().findFirst().map(Station::getName)).contains("잠실역");
    }

    @DisplayName("노선에 포함된 역이 2 개 이하일 때, 구간 삭제 시 예외 처리")
    @Test
    void exceptDeleteSectionBySize() {
        Line line = new Line("2호선");
        line.addStations("잠실역");
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> line.deleteSection(StationRepository.searchStation("잠실역")));
    }

    @DisplayName("노선에 포함된 구간 삭제")
    @Test
    void deleteSection() {
        Line line = new Line("2호선");
        line.addStations("잠실역");
        line.addStations("강남역");
        line.addStations("교대역");
        line.deleteSection(StationRepository.searchStation("잠실역"));
        assertThat(line.getStations().stream().map(Station::getName)).containsAll(Arrays.asList("강남역", "교대역"));
    }
}