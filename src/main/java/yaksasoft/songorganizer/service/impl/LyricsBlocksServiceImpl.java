package yaksasoft.songorganizer.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yaksasoft.songorganizer.entity.LyricsBlock;
import yaksasoft.songorganizer.entity.Project;
import yaksasoft.songorganizer.entity.dto.request.LyricsBlockCreateRequest;
import yaksasoft.songorganizer.entity.dto.request.LyricsBlockUpdateRequest;
import yaksasoft.songorganizer.entity.dto.response.LyricsBlockResponse;
import yaksasoft.songorganizer.entity.enums.ErrorMessages;
import yaksasoft.songorganizer.exception.LyricsBlockNotFoundException;
import yaksasoft.songorganizer.exception.ProjectNotFoundException;
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
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(ErrorMessages.PROJECT_NOT_FOUND.getMessage()));
        LyricsBlock blockToSave = lyricsBlockMapper.toEntity(request, project);
        lyricsBlocksRepository.save(blockToSave);
        return lyricsBlockMapper.toResponse(blockToSave);
    }

    @Override
    public LyricsBlockResponse getById(Long blockId, Long projectId) {
        return lyricsBlocksRepository.findByIdAndProjectId(blockId, projectId).map(lyricsBlockMapper::toResponse)
                .orElseThrow(() -> new LyricsBlockNotFoundException(ErrorMessages.LYRICS_BLOCK_NOT_FOUND.getMessage()));
    }

    @Override
    public LyricsBlockResponse update(Long blockId, LyricsBlockUpdateRequest request, Long projectId) {
        LyricsBlock lyricsBlock = lyricsBlocksRepository
                .findByIdAndProjectId(blockId, projectId)
                .orElseThrow(() -> new LyricsBlockNotFoundException(ErrorMessages.LYRICS_BLOCK_NOT_FOUND.getMessage()));

        lyricsBlockMapper.updateEntity(lyricsBlock, request);

        LyricsBlock updatedBlock = lyricsBlocksRepository.save(lyricsBlock);

        return lyricsBlockMapper.toResponse(updatedBlock);
    }

    @Override
    public List<LyricsBlockResponse> getAll(Long projectId) {
        return lyricsBlocksRepository.findAllByProjectId(projectId).stream().map(lyricsBlockMapper::toResponse).toList();
    }


}
