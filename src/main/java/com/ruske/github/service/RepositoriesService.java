package com.ruske.github.service;

import com.ruske.github.dto.RepositoryDTO;

import java.util.List;

public interface RepositoriesService {
    List<RepositoryDTO> findStarredByUserName(String userName);
}
