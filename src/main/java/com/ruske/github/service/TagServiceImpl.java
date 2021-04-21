package com.ruske.github.service;

import com.ruske.github.model.Tag;
import com.ruske.github.repository.ITagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    ITagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag store(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> findByIdGithub(Integer idGithub) {
        return tagRepository.findByIdGithub(idGithub);
    }
}
