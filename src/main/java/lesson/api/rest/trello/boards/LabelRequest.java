package lesson.api.rest.trello.boards;

public class LabelRequest {

    private String name;
    private String color;

    public LabelRequest(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "LabelRequest{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
