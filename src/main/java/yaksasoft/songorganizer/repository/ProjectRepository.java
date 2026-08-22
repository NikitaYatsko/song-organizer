package yaksasoft.songorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yaksasoft.songorganizer.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
