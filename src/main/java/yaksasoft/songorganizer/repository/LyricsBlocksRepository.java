package yaksasoft.songorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yaksasoft.songorganizer.entity.LyricsBlock;

import java.util.List;


public interface LyricsBlocksRepository extends JpaRepository<LyricsBlock, Long> {
    List<LyricsBlock> findAllByProjectId(Long projectId);
}
