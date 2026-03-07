package models;

public enum PatientType {
    PRIMARY("ВАЖНЫЙ"),
    SECONDARY("ВТОРИЧНЫЙ");

    private String title;

    PatientType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PatientType{");
        sb.append("title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
