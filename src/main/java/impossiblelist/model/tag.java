package impossiblelist.model;

import lombok.Data;

@Data
public class tag {
    private String id;
    private String name;
    private String description;
    private String color;

    public tag(String name, String description, String color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public tag(String id, String name, String description, String color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
    }
}
