package com.ruske.github.service;

import com.ruske.github.dto.RepositoryDTO;

import java.util.List;
import java.util.UUID;

public interface IRepositoriesService {
    List<RepositoryDTO> findStarredByUserName(String userName);

    RepositoryDTO findById(Integer id);

    List<RepositoryDTO> findByTag(UUID id);
}
