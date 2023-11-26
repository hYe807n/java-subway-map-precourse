package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line searchLine(String lineName) {
        return lines.stream().filter(
            line -> line.getName().equals(lineName)
        ).findFirst().orElse(null);
    }

    public static void addSections(String line, String index, String station) {
        if (StationRepository.searchStation(station) == null) {
            StationRepository.addStation(new Station(station));
        }
        if (LineRepository.searchLine(line) == null) {
            LineRepository.addLine(new Line(line));
        }
        LineRepository.searchLine(line).getStations()
                .add(Integer.parseInt(index) - 1, StationRepository.searchStation(station));
    }
}
