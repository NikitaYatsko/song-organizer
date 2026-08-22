package yaksasoft.songorganizer.entity;

import jakarta.persistence.*;
import lombok.*;
import yaksasoft.songorganizer.entity.enums.ProjectStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects" ,schema = "organizer_schema")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name", nullable = false, length = 128)
    private String projectName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 32)
    private ProjectStatus status;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("blockOrder ASC")
    private List<LyricsBlock> lyricsBlocks = new ArrayList<>();
}