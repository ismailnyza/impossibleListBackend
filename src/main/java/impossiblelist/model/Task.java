package impossiblelist.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "tasks")
public class Task {
    private String id;

    private String name;
    private String description;
    private Date dueDate;
//    how do only enable specific features
    private priority priority;
    private status status;
    private List<tag> tagList;
//    todo add subtasks
    private List<comment> commentList;
    private User assignee;
    private User creator;
    private Date createdDate;
    private Date lastUpdatedDate;;
}
