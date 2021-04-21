package com.ruske.github.service;

import com.ruske.github.dto.RepositoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class RepositoriesServiceImpl implements IRepositoriesService {

    @Autowired
    ITagService tagService;

    @Override
    public List<RepositoryDTO> findStarredByUserName(final String userName) {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "https://api.github.com/users/" + userName.trim() + "/starred";
        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (Exception e ) {
            log.error("Error on create URI", e);
            return Arrays.asList(new RepositoryDTO());
        }

        RepositoryDTO[] result = restTemplate.getForObject(uri, RepositoryDTO[].class);

        return setTagsOnRepositories(Arrays.asList(result));
    }

    @Override
    public RepositoryDTO findById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "https://api.github.com/repositories/" + id;
        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (Exception e ) {
            log.error("Error on create URI", e);
            return new RepositoryDTO();
        }

        return setTagsOnRepositories(restTemplate.getForObject(uri, RepositoryDTO.class));
    }

    @Override
    public List<RepositoryDTO> findByTag(UUID id) {
        return null;
    }

    private List<RepositoryDTO> setTagsOnRepositories(List<RepositoryDTO> repositoryList) {
        if (!CollectionUtils.isEmpty(repositoryList)) {
            repositoryList.stream().forEach(repo -> {
                repo.setGithubTags(tagService.findByIdGithub(repo.getId()));
            });
        }
        return repositoryList;
    }

    private RepositoryDTO setTagsOnRepositories(RepositoryDTO repositoryDTO) {
        if (Objects.isNull(repositoryDTO)) {
            return new RepositoryDTO();
        }

        List<RepositoryDTO> repositoryDTOList = new ArrayList<>();
        repositoryDTOList.add(repositoryDTO);

        return setTagsOnRepositories(repositoryDTOList).get(0);
    }
}
