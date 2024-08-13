package impossiblelist.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "tasks")
public class Task {
    private String id;
    private String name;
    private String description;
    private Date dueDate;
    private priority priority;
    private status status;
    private List<tag> tagList;
    private List<Task> subTaskList;
    private List<comment> commentList;
    private User assignee;
    private User creator;
    private Date createdDate;
    private Date lastUpdatedDate;

    public Task(User assignee, List<comment> commentList, Date createdDate, User creator, String description, Date dueDate, Date lastUpdatedDate, impossiblelist.model.priority priority, String name, impossiblelist.model.status status, List<tag> tagList, List<Task> subTaskList) {
        this.commentList = commentList;
        this.createdDate = createdDate;
        this.creator = creator;
        this.description = description;
        this.dueDate = dueDate;
        this.lastUpdatedDate = createdDate;
        this.priority = Objects.requireNonNullElseGet(priority, () -> impossiblelist.model.priority.valueOf("LOW"));
        this.name = name;
        this.status = Objects.requireNonNullElseGet(status, () -> impossiblelist.model.status.valueOf("PENDING"));
        this.tagList.addAll(tagList);
        }
}
