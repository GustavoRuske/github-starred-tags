package com.ruske.github.service;

import com.ruske.github.dto.RepositoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class RepositoriesServiceImpl implements RepositoriesService {

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

        return Arrays.asList(result);
    }
}
