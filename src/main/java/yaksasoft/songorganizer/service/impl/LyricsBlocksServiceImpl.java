package yaksasoft.songorganizer.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yaksasoft.songorganizer.entity.LyricsBlock;
import yaksasoft.songorganizer.entity.Project;
import yaksasoft.songorganizer.entity.dto.request.LyricsBlockCreateRequest;
import yaksasoft.songorganizer.entity.dto.response.LyricsBlockResponse;
import yaksasoft.songorganizer.mapper.LyricsBlockMapper;
import yaksasoft.songorganizer.repository.LyricsBlocksRepository;
import yaksasoft.songorganizer.repository.ProjectRepository;
import yaksasoft.songorganizer.service.LyricsBlocksService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LyricsBlocksServiceImpl implements LyricsBlocksService {
    private final ProjectRepository projectRepository;
    private final LyricsBlocksRepository lyricsBlocksRepository;
    private final LyricsBlockMapper lyricsBlockMapper;


    @Override
    public LyricsBlockResponse create(LyricsBlockCreateRequest request, Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Project not found"));
        LyricsBlock blockToSave = lyricsBlockMapper.toEntity(request, project);
        lyricsBlocksRepository.save(blockToSave);
        return lyricsBlockMapper.toResponse(blockToSave);
    }

    @Override
    public LyricsBlockResponse getById(Long blockId, Long projectId) {
       Project project = projectRepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Project not found"));
return null;
    }

    @Override
    public List<LyricsBlockResponse> getAll(Long projectId) {
        return List.of();
    }
}
