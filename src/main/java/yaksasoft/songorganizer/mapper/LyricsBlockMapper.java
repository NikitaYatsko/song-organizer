package yaksasoft.songorganizer.mapper;

import org.springframework.stereotype.Component;
import yaksasoft.songorganizer.entity.LyricsBlock;
import yaksasoft.songorganizer.entity.Project;
import yaksasoft.songorganizer.entity.dto.request.LyricsBlockCreateRequest;
import yaksasoft.songorganizer.entity.dto.request.LyricsBlockUpdateRequest;
import yaksasoft.songorganizer.entity.dto.response.LyricsBlockResponse;

@Component
public class LyricsBlockMapper {

    public LyricsBlock toEntity(LyricsBlockCreateRequest request, Project project) {
        LyricsBlock lyricsBlock = new LyricsBlock();
        lyricsBlock.setBlockName(request.blockName());
        lyricsBlock.setBlockOrder(request.blockOrder());
        lyricsBlock.setContent(request.content());
        lyricsBlock.setProject(project);
        return lyricsBlock;
    }

    public void updateEntity(LyricsBlock entity, LyricsBlockUpdateRequest request) {
        entity.setBlockName(request.blockName());
        entity.setContent(request.content());
        entity.setBlockOrder(request.blockOrder());
    }

    public LyricsBlockResponse toResponse(LyricsBlock block) {
        return new LyricsBlockResponse(
                block.getId(),
                block.getBlockName(),
                block.getContent(),
                block.getBlockOrder(),
                block.getCreatedAt()
        );
    }


}
