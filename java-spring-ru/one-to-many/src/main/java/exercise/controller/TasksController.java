package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskMapper taskMapper;
    @GetMapping(path = "")
    public List<TaskDTO> index() {
        var tasksDTO = taskRepository.findAll().stream()
                .map(t -> taskMapper.map(t))
                .toList();
        return tasksDTO;
    }

    @GetMapping(path = "/{id}")
    public TaskDTO show(@PathVariable long id) {
        var task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task with id "
                + id + " not found"));
        return taskMapper.map(task);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@Valid @RequestBody TaskCreateDTO taskCreateData) {
        var task = taskMapper.map(taskCreateData);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO update(@PathVariable long id, @Valid @RequestBody TaskUpdateDTO taskUpdateData) {
        var task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task with id "
                + id + " not found"));
        taskMapper.update(taskUpdateData, task);
        task.setAssignee(userRepository.findById(taskUpdateData.getAssigneeId()).get());
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        taskRepository.deleteById(id);
    }
    // END
}
