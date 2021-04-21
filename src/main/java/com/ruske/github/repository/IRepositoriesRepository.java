package com.ruske.github.repository;

import com.ruske.github.dto.RepositoryDTO;
import com.ruske.github.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoriesRepository {
    List<RepositoryDTO> findStarredByUserName(String userName);
    List<RepositoryDTO> findStarredByTag(Tag tag);
}