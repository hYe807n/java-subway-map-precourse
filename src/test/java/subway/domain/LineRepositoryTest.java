package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineRepositoryTest {

    @DisplayName("\"2호선\"을 노선에 추가")
    @Test
    void addLines() {
        LineRepository.addLine(new Line("2호선"));
        Assertions.assertTrue(LineRepository.lines().stream().anyMatch( line ->
            line.getName().equals("2호선")));
    }

    @DisplayName("노선 이름 중복 시 예외 처리")
    @Test
    void addLineByDuplicateName() {
        LineRepository.addLine(new Line("2호선"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            LineRepository.addLine(new Line("2호선")));
    }
}