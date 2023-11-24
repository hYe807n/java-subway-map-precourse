package subway.enums;

public enum MainForm {
    MAIN_MASSAGE("## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료"),
    USER_FEATURE("\n## 원하는 기능을 선택하세요."),
    CHOOSE_STATION("1"),
    CHOOSE_LINE("2"),
    CHOOSE_SECTION("3"),
    CHOOSE_PRINT_SECTIONS("4"),
    EXIT("Q"),
    INFO_ERROR("\n[ERROR] "),
    INFO_FORM("\n[INFO] ");

    private final String message;

    MainForm(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
