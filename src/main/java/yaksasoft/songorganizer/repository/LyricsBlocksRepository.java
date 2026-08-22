package yaksasoft.songorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yaksasoft.songorganizer.entity.LyricsBlock;

import java.util.List;
import java.util.Optional;


public interface LyricsBlocksRepository extends JpaRepository<LyricsBlock, Long> {
    List<LyricsBlock> findAllByProjectId(Long projectId);
    Optional<LyricsBlock> findByIdAndProjectId(Long blockId, Long projectId);
}
