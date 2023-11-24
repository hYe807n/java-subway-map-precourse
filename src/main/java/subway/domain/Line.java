package subway.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Line {
    private String name;
    private Queue<Station> stations = new LinkedList<>();

    public Line(String name) {
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
}
