package subway.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Line {
    private String name;
    Queue<Station> stations = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStations(String station) {
        stations.add(StationRepository.searchStation(station));
    }
}
