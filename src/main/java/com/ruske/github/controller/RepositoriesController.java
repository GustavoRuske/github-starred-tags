package com.ruske.github.controller;

import com.ruske.github.dto.RepositoryDTO;
import com.ruske.github.repository.TagRepository;
import com.ruske.github.service.RepositoriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController()
@RequestMapping("/repositories")
public class RepositoriesController {

    @Autowired
    private RepositoriesService repositoriesService;

    @Autowired
    private TagRepository tagRepository;

    @RequestMapping(path = "/starred/{name}", method = RequestMethod.GET)
    public List<RepositoryDTO> getStarredRepository(@PathVariable String name) {
        log.info("Repository " + name + " has called!");
        List<RepositoryDTO> repos = repositoriesService.findStarredByUserName(name);

        if (!CollectionUtils.isEmpty(repos)) {
            repos.stream().forEach(repo -> {
                repo.setGithubTags(tagRepository.findByIdGithub(repo.getId()));
            });
        }
        return repos;
    }
}
