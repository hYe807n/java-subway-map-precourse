package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void deleteSection() {
    }
}