package subway.domain;


public class Station {
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isLine() {
        return LineRepository.lines().stream().map(Line::getStations).anyMatch(
            stations -> stations.stream().anyMatch(
                station -> station.getName().equals(name)
            )
        );
    }

    private void validate(String name) {
        if (StationRepository.searchStation(name) != null) {
            throw new IllegalArgumentException("지하철 역 이름이 중복되었습니다.");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("지하철 역 이름은 2 글자 이상이어야 합니다.");
        }
    }
}
