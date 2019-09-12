package com.spring.gatewayadmin.route.entity;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class GatewayFilters {
    private String name;
//    private List<String> args;
    private Map<String, String> args = new LinkedHashMap<>();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
