package yaksasoft.songorganizer.entity.dto;

import java.time.LocalDateTime;

public record LyricsBlockResponse(
        Long id,
        String blockName,
        String content,
        Integer blockOrder,
        LocalDateTime createdAt
) {
}