package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InitializerTest {

    @DisplayName("노선 정보가 주어진 요구사항대로 초기화")
    @Test
    void informs() {
        Initializer.informs();
        List<String> lines = LineRepository.lines().stream().map(Line::getName).collect(Collectors.toList());
        assertThat(lines).containsAll(Arrays.asList("2호선", "3호선", "신분당선"));
    }
}