package exercise.controller;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.sql.SQLException;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    private Task generateTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
    }

    // BEGIN
    @Test
    public void testCreate() throws Exception {
        Task task = generateTask();
        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(task));

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();
        assertThat(taskRepository.findAll()).hasSize(1);
    }

    @Test
    public void testShow() throws Exception {
        Task task = generateTask();
        taskRepository.save(task);
//        var request = post("/tasks")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(om.writeValueAsString(task));
//        mockMvc.perform(request)
//                .andExpect(status().isCreated())
//                .andReturn();

        var result = mockMvc.perform(get("/tasks/{id}", task.getId()))
                .andExpect(status().isOk())
                .andReturn();
        var body = result.getResponse().getContentAsString();
        assertThat(body.contains(task.getTitle()));
    }

    @Test
    public void testUpdate() throws Exception {
        Task task1 = generateTask();
        taskRepository.save(task1);
//        var request1 = post("/tasks")
//                .contentType(MediaType.APPLICATION_JSON)
//                        .content(om.writeValueAsString(task1));
//
//        mockMvc.perform(request1)
//                .andExpect(status().isCreated())
//                .andReturn();

        Task task2 = generateTask();
        task2.setDescription("blablabla");
        task2.setTitle("nothing to do");

        var request2 = put("/tasks/{id}", task1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(task2));
        mockMvc.perform(request2)
                .andExpect(status().isOk())
                .andReturn();
        var actualTask = taskRepository.findById(task1.getId()).get();
        assertThat(actualTask.getDescription()).isEqualTo(task2.getDescription());
        assertThat(actualTask.getTitle()).isEqualTo(task2.getTitle());


    }

    @Test
    public void testDelete() throws Exception {
        Task task = generateTask();
        taskRepository.save(task);
//        var request = post("/tasks")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(om.writeValueAsString(task));
//        mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andReturn();
        mockMvc.perform(delete("/tasks/{id}", task.getId()))
                .andExpect(status().isOk())
                .andReturn();
        assertThat(taskRepository.findAll()).isEmpty();



    }
    // END
}
