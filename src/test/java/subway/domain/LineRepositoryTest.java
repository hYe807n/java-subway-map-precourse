package subway.domain;

import static subway.domain.InitializerTest.initializeTest;

import java.util.Collections;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineRepositoryTest {

    @BeforeEach
    void initialize() {
        initializeTest();
    }

    @DisplayName("\"2호선\"을 노선에 추가")
    @Test
    void addLinesByName() {
        LineRepository.addLine(new Line("2호선"));
        Assertions.assertTrue(LineRepository.lines().stream().anyMatch( line ->
            line.getName().equals("2호선")));
    }

    @DisplayName("\"5호선\" 노선 삭제")
    @Test
    void deleteLineByName() {
        LineRepository.addLine(new Line("5호선"));
        LineRepository.deleteLineByName("5호선");
        Assertions.assertNull(LineRepository.searchLine("5호선"));
    }

    @DisplayName("노선 이름을 통해 \"8호선\" 노선 검색하는 기능")
    @Test
    void searchLineByName() {
        LineRepository.addLine(new Line("8호선"));
        Assertions.assertEquals(LineRepository.searchLine("8호선").getName(), "8호선");
    }

    @DisplayName("\"7호선\"에 \"신림역\" 구간 추가 기능")
    @Test
    void addSectionsByLineStation() {
        LineRepository.addLine(new Line("7호선"));
        LineRepository.addSections("7호선", "1", "신림역");
        Assertions.assertEquals(LineRepository.searchLine("7호선").getStations()
                .stream().map(Station::getName).collect(Collectors.toList()),
            Collections.singletonList("신림역"));
    }
}