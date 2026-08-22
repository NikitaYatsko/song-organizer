package yaksasoft.songorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yaksasoft.songorganizer.entity.LyricsBlock;


public interface LyricsBlocksRepository extends JpaRepository<LyricsBlock, Long> {

}
