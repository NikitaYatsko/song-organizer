package yaksasoft.songorganizer.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "lyrics_blocks", schema = "organizer_schema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LyricsBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "block_name", nullable = false, length = 128)
    private String blockName;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "block_order", nullable = false)
    private Integer blockOrder;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;
}