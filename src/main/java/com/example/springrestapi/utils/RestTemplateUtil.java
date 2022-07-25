package com.example.springrestapi.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateUtil {

    @Autowired
    private RestTemplate restTemplate;

    public HttpEntity<String> getAuthenHttpEntity(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        return new HttpEntity<String>(headers);
    }

    public void authVerify(HttpServletRequest request, String url) throws Exception {
        restTemplate.exchange(url, HttpMethod.GET, getAuthenHttpEntity(request.getHeader("Authorization")),
                Object.class);
    }
}
