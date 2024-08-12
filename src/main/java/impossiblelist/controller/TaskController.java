package impossiblelist.controller;

import impossiblelist.DTO.TaskDTO;
import impossiblelist.model.Task;
import impossiblelist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow only this origin
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable String id) {
        Task task = taskService.getTaskById(id);
        return new TaskDTO(task.getId(), task.getName());
    }

    @GetMapping("/all")
        public List<Task> getAllTasks () {
            return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    @DeleteMapping("/all")
    public void deleteAllTasks() {
        taskService.deleteAllTasks();
    }


}
