package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class Line {

    private static final int MINIMUM_LENGTH = 2;

    private String name;
    private List<Station> stations = new LinkedList<>();

    public Line(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStations(String station) {
        if (StationRepository.searchStation(station) == null) {
            StationRepository.addStation(new Station(station));
        }
        stations.add(StationRepository.searchStation(station));
    }

    public void deleteSection(Station station) {
        if (stations.size() <= MINIMUM_LENGTH) {
            throw new IllegalArgumentException("노선에 포함된 역이 두 개 이하일 때는 역을 삭제할 수 없습니다.");
        }
        stations.remove(station);
    }

    private void validate(String name) {
        if (LineRepository.searchLine(name) != null) {
            throw new IllegalArgumentException("지하철 노선 이름이 중복되었습니다.");
        }
        if (name.length() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("지하철 노선 이름은 2 글자 이상이어야 합니다.");
        }
    }
}
