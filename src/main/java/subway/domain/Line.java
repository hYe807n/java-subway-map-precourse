package subway.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Line {
    private String name;
    private Queue<Station> stations = new LinkedList<>();

    public Line(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Queue<Station> getStations() {
        return stations;
    }

    public void addStations(String station) {
        stations.add(StationRepository.searchStation(station));
    }

    private void validate(String name) {
        if (LineRepository.searchLine(name) != null) {
            throw new IllegalArgumentException("지하철 노선 이름이 중복되었습니다.");
        }
//        if (name.length() < 2) {
//            throw new IllegalArgumentException("지하철 역 이름은 2 글자 이상이어야 합니다.");
//        }
    }
}
