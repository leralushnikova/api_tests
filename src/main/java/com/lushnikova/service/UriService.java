package com.lushnikova.service;

import java.net.URI;

public class UriService {
    public URI createUri(String site) {
        return URI.create(site);
    }
}