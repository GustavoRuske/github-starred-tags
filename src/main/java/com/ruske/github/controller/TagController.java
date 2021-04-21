package com.ruske.github.controller;

import com.ruske.github.model.Tag;
import com.ruske.github.service.ITagService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController()
@RequestMapping("/tags")
public class TagController {
    @Autowired
    ITagService ITagService;

    @GetMapping()
    public ResponseEntity<List<Tag>> getTags(){
        return ResponseEntity.ok().body(ITagService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return ResponseEntity.ok().body(ITagService.store(tag));
    }

    @GetMapping("/{idGithub}")
    public ResponseEntity<List<Tag>> getTagsBIdGithub(@PathVariable @NotNull Integer idGithub){
        return ResponseEntity.ok().body(ITagService.findByIdGithub(idGithub));
    }
}
