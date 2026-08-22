package yaksasoft.songorganizer.entity.dto.request;

public record LyricsBlockUpdateRequest(String blockName,
                                       String content,
                                       Integer blockOrder) {
}
