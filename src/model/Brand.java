package model;

public class Brand {
    private Integer id;
    private String name;

    public Brand(Integer id) {
        this.id = id;
    }

    // TESTING PURPOSES ONLY ↓↓
    public Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    // REMOVE LATER, USELESS ↑↑

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
