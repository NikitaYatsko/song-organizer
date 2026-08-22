package yaksasoft.songorganizer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yaksasoft.songorganizer.entity.dto.request.LyricsBlockCreateRequest;
import yaksasoft.songorganizer.entity.dto.response.LyricsBlockResponse;
import yaksasoft.songorganizer.service.LyricsBlocksService;

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
}


