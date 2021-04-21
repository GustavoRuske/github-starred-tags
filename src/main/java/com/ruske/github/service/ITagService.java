package com.ruske.github.service;

import com.ruske.github.model.Tag;

import java.util.List;

public interface ITagService {
    List<Tag> findAll();
    Tag store(Tag tag);
    List<Tag> findByIdGithub(Integer idGithub);
}
