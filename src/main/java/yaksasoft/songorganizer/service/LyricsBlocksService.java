package yaksasoft.songorganizer.service;

import yaksasoft.songorganizer.entity.dto.request.LyricsBlockCreateRequest;
import yaksasoft.songorganizer.entity.dto.request.LyricsBlockUpdateRequest;
import yaksasoft.songorganizer.entity.dto.response.LyricsBlockResponse;

import java.util.List;

public interface LyricsBlocksService {
    LyricsBlockResponse create(LyricsBlockCreateRequest request, Long projectId);
    LyricsBlockResponse getById(Long blockId, Long projectId);
    LyricsBlockResponse update(Long blockId, LyricsBlockUpdateRequest request, Long projectId);
    List<LyricsBlockResponse> getAll(Long projectId);

}
