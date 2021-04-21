package com.ruske.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruske.github.model.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RepositoryDTO {
    Integer id;

    String name;

    String description;

    List<Tag> githubTags;

    @JsonProperty("stargazers_count")
    Integer starCount;

    String language;

    @JsonProperty("html_url")
    String url;
}
