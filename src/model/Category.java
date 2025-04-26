package model;

public class Category {
    private Integer id;
    private String label;

    public Category(Integer id) {
        this.id = id;
    }

    // TESTING PURPOSES ONLY ↓↓
    public Category(Integer id, String label) {
        this.id = id;
        this.label = label;
    }
    // REMOVE LATER, USELESS ↑↑

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
