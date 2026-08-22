package yaksasoft.songorganizer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yaksasoft.songorganizer.entity.dto.request.ProjectCreateRequest;
import yaksasoft.songorganizer.entity.dto.response.ProjectResponse;
import yaksasoft.songorganizer.entity.dto.request.ProjectStatusUpdateRequest;
import yaksasoft.songorganizer.service.ProjectService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponse> create(
            @RequestBody ProjectCreateRequest request
    ) {
        ProjectResponse response = projectService.create(request);

        return ResponseEntity
                .created(URI.create("/api/projects/" + response.id()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                projectService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAll() {
        return ResponseEntity.ok(
                projectService.getAll()
        );
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<ProjectResponse> updateStatus(
            @PathVariable Long id,
            @RequestBody ProjectStatusUpdateRequest request
    ) {
        return ResponseEntity.ok(
                projectService.updateStatus(request.status(), id)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        projectService.delete(id);

        return ResponseEntity.noContent().build();
    }
}