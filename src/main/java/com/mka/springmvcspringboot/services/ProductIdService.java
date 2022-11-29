package com.mka.springmvcspringboot.services;

import org.springframework.stereotype.Component;

@Component
public class ProductIdService {

    private int id;

    public int giveId() {
        return id += 10;
    }
}
