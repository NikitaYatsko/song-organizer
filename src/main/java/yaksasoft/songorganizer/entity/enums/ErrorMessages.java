package yaksasoft.songorganizer.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessages {
    USER_NOT_FOUND("User not found"),
    PROJECT_NOT_FOUND("Project not found"),
    LYRICS_BLOCK_NOT_FOUND("Lyrics block not found");

    private final String message;

    public String format(Object... args) {
        return message.formatted(args);
    }
    }
