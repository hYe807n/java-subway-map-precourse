package subway.enums;

public enum LineForm {
    MAIN_LINE_MESSAGE("\n## 노션 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기"),
    LINE_ADD("\n## 등록할 노선 이름을 입력하세요."),
    LINE_DELETE("\n## 삭제할 노선 이름을 입력하세요."),
    LINE_FIRST("\n## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    LINE_LAST("\n## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    LINES("\n## 노선 목록"),
    CHOOSE_ADD("1"),
    CHOOSE_DELETE("2"),
    CHOOSE_VIEW("3"),
    EXIT("B"),
    STATION_ADD_SUCCESS("지하철 노선이 등록되었습니다."),
    STATION_DELETE_SUCCESS("지하철 노선이 삭제되었습니다.");
    private final String message;

    LineForm(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
