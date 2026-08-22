package yaksasoft.songorganizer.entity.dto.request;

public record LyricsBlockCreateRequest(
        String blockName,
        String content,
        Integer blockOrder
) {
}