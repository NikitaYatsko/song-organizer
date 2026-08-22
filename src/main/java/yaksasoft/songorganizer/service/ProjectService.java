package yaksasoft.songorganizer.service;


import org.springframework.transaction.annotation.Transactional;
import yaksasoft.songorganizer.entity.dto.ProjectCreateRequest;
import yaksasoft.songorganizer.entity.dto.ProjectResponse;
import yaksasoft.songorganizer.entity.enums.ProjectStatus;

import java.util.List;

public interface ProjectService {

    ProjectResponse create(ProjectCreateRequest request);

    ProjectResponse getById(Long id);


    @Transactional
    ProjectResponse updateStatus(ProjectStatus status, Long id);

    List<ProjectResponse> getAll();

    void delete(Long id);
}