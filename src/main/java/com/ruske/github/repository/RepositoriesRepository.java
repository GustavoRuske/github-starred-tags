package com.ruske.github.repository;

import com.ruske.github.dto.RepositoryDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoriesRepository {
    List<RepositoryDTO> findStarredByUserName(String userName);
}