package yaksasoft.songorganizer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yaksasoft.songorganizer.entity.dto.request.LyricsBlockCreateRequest;
import yaksasoft.songorganizer.entity.dto.request.LyricsBlockUpdateRequest;
import yaksasoft.songorganizer.entity.dto.response.LyricsBlockResponse;
import yaksasoft.songorganizer.service.LyricsBlocksService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/projects/{projectId}/lyrics-blocks")
public class LyricsBlocksController {
    private final LyricsBlocksService lyricsBlocksService;

    @PostMapping
    public ResponseEntity<LyricsBlockResponse> create(
            @PathVariable Long projectId,
            @RequestBody LyricsBlockCreateRequest request
    ) {
        LyricsBlockResponse response =
                lyricsBlocksService.create(request, projectId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<LyricsBlockResponse>> getAll(@PathVariable Long projectId) {
        return ResponseEntity.ok(lyricsBlocksService.getAll(projectId));
    }

    @PutMapping("/{blockId}")
    public ResponseEntity<LyricsBlockResponse> update(@PathVariable Long blockId, @RequestBody LyricsBlockUpdateRequest request, @PathVariable Long projectId) {
        return ResponseEntity.ok(lyricsBlocksService.update(blockId, request, projectId));
    }

    @GetMapping("/{blockId}")
    public ResponseEntity<LyricsBlockResponse> getById(@PathVariable Long blockId, @PathVariable Long projectId) {
        return ResponseEntity.ok(lyricsBlocksService.getById(blockId, projectId));
    }
}


