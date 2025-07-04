package org.example.schoolclass.util;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestClient<T,U> {

    private final RestTemplate template;
    private final HttpHeaders headers;
    private final String urlApi;

    public RestClient(String urlApi, RestTemplate template) {
        this.urlApi = urlApi;
        this.template = template;
        this.headers = new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON);
        this.headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    }

    public T get(U id,Class<T> responseType){
        HttpEntity<String> requestEntity = new HttpEntity<>("",headers);
        ResponseEntity<T> response = template.exchange(urlApi+id, HttpMethod.GET,requestEntity,responseType);
        if(response.hasBody()){
            return response.getBody();
        }
        return null;
    }

    public List<T> get(){

        HttpEntity<String> requestEntity = new HttpEntity<>("",headers);
        ResponseEntity<List<T>> response = template.exchange(urlApi,HttpMethod.GET,requestEntity,new ParameterizedTypeReference<List<T>>(){});
        if(response.hasBody())
            return response.getBody();
        return null;
    }
}
