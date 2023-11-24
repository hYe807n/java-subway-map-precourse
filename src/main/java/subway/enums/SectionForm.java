package subway.enums;

public enum SectionForm {
    MAIN_SECTION_MESSAGE("\n## 구간 관리 화면\n1.구간 등록\n2. 구간 삭제\nB. 돌아가기"),
    SECTION_LINE("\n## 노선을 입력하세요."),
    SECTION_STATION("\n## 역 이름을 입력하세요."),
    SECTION_SEQUENCE("\n## 순서를 입력하세요."),

    DELETE_LINE("\n## 삭제한 구간의 노선을 입력하세요."),
    DELETE_STATION("\n## 삭제한 구간의 역을 입력하세요."),

    CHOOSE_ADD("1"),
    CHOOSE_DELETE("2"),
    EXIT("B"),

    STATION_ADD_SUCCESS("구간이 등록되었습니다."),
    STATION_DELETE_SUCCESS("구간이 삭제되었습니다.");
    private final String message;

    SectionForm(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
