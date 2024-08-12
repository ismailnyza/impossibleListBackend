package impossiblelist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "sub-tasks")
public class SubTask extends Task {
    private String parentTaskId;
//    anything fancy goes here
}
