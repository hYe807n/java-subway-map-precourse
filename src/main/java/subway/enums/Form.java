package subway.enums;

public enum Form {
    MAIN_MASSAGE("## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료");

    private final String message;

    Form(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
