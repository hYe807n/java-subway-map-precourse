package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isLine() {
        return LineRepository.lines().stream().anyMatch(
            line -> line.stations.contains(this.name)
        );
    }
}
