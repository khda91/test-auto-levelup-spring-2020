package lesson.api.trello.boards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelResponse {

    private String id;
    private String idBoard;
    private String name;
    private String color;

    public LabelResponse() {
    }

    public String getId() {
        return id;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "LabelResponse{" +
                "id='" + id + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
