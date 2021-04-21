package com.ruske.github.controller;

import com.ruske.github.dto.RepositoryDTO;
import com.ruske.github.repository.ITagRepository;
import com.ruske.github.service.IRepositoriesService;
import com.ruske.github.service.ITagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@RestController()
@RequestMapping("/repositories")
public class RepositoriesController {

    @Autowired
    private IRepositoriesService repositoriesService;

    @Autowired
    private ITagService tagService;

    @RequestMapping(path = "/starred/{name}", method = RequestMethod.GET)
    public List<RepositoryDTO> getStarredRepository(@PathVariable String name) {
        log.info("Repository by name {" + name + "} has called!");
        List<RepositoryDTO> repos = repositoriesService.findStarredByUserName(name);
        return repos;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public RepositoryDTO getRepositoryById(@PathVariable Integer id) {
        log.info("Repository by id {" + id + "} has called!");
        RepositoryDTO repo = repositoriesService.findById(id);

        return repo;
    }

    @RequestMapping(path = "/tag/{tagId}", method = RequestMethod.GET)
    public List<RepositoryDTO> getRepositoryByTag(@PathVariable UUID tagId) {
        log.info("Repository by tag {" + tagId + "} has called!");
        List<RepositoryDTO> repos = repositoriesService.findByTag(tagId);

        return repos;
    }
}
