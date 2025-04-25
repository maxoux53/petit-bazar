package view;

public enum FontPreferences {
    // Enum
    DEFAULT_STYLE("SansSerif"),
    TITLE_SIZE(60),
    MID_SIZE(25),
    NORMAL_SIZE(20);

    // Attributes
    private String style;
    private int size;

    // Constructors
    FontPreferences(String value) {
        this.style = value;
    }

    FontPreferences(int value) {
        this.size = value;
    }

    // Getters
    public String getStyle() {
        return style;
    }

    public int getSize() {
        return size;
    }
}
