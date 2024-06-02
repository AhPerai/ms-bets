package com.ms.ms_bets.domain.port.requets;

import org.springframework.web.client.RestClient;

public abstract class BaseRestClient {

    protected RestClient restClient;
    protected static String BASE_URL;

    public BaseRestClient() {
        setBaseUrl();
        validateBaseUrl();
        buildRestClient();
    }

    protected abstract void setBaseUrl();

    public static String getBaseUrl() {
        return BASE_URL;
    }

    private void validateBaseUrl() {
        if (BASE_URL == null || BASE_URL.isEmpty()) {
            throw new IllegalArgumentException("The base url must be set to be able to make rest calls");
        }
    }

    private void buildRestClient() {
        restClient = RestClient.builder().baseUrl(BASE_URL).build();
    }

}
