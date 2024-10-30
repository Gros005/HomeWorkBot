package ru.homework.homeworkbot.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.homework.homeworkbot.model.Homework;
import ru.homework.homeworkbot.service.HomeworkService;

import java.util.List;

@RestController
@RequestMapping("/api/homework")
public class HomeworkController {

    private final HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @PostMapping
    public ResponseEntity<Homework> addHomework(@RequestBody Homework homework) {
        return ResponseEntity.ok(homeworkService.saveHomework(homework));
    }

    @GetMapping
    public List<Homework> getAllHomework() {
        return homeworkService.getAllHomework();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Homework> getHomeworkById(@PathVariable Long id) {
        return homeworkService.getHomeworkById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHomework(@PathVariable Long id) {
        homeworkService.deleteHomework(id);
        return ResponseEntity.noContent().build();
    }
}
