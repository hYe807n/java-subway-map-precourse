package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void deleteStation(String name) {
        Station stationDelete = stations().stream().filter(
            station -> Objects.equals(station.getName(), name)
        ).findFirst().orElse(null);
        if (stationDelete.isLine()) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static Station searchStation(String stationName) {
        return stations.stream().filter(
            station -> station.getName().equals(stationName)
        ).findFirst().orElse(null);
    }
}
