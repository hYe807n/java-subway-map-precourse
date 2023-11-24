package subway.enums;

public enum StationForm {
    MAIN_STATION_MESSAGE("\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기"),
    STATION_ADD("\n## 등록할 역 이름을 입력하세요."),
    STATION_DELETE("\n## 삭제할  역 이름을 입력하세요."),
    STATIONS("\n## 역 목록"),
    CHOOSE_ADD("1"),
    CHOOSE_DELETE("2"),
    CHOOSE_VIEW("3"),
    EXIT("B"),
    STATION_ADD_SUCCESS("지하철 역이 등록되었습니다."),
    STATION_DELETE_SUCCESS("지하철 역이 삭제되었습니다.");
    private final String message;

    StationForm(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
