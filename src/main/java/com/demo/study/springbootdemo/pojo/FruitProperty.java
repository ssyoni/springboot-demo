package com.demo.study.springbootdemo.pojo;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("fruit")
public class FruitProperty {
    private List<Map> list;

}
