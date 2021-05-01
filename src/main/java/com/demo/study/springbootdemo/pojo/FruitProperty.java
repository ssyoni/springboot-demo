package com.demo.study.springbootdemo.pojo;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("fruit") 
public class FruitProperty {
    /*
    @ConfigurationProperties
     - 접두사를 활용하여 원하는 객체를 바인딩 해준다. @Value보다 더 객체지향적으로 프로퍼티를 매핑한다. 
     - @ConfigurationProperties를 사용하려면 해당 클래스를 @Component로 선언해야 의존성 주입이 가능하다.
     - application.yml이 아는 다른 이름의 YAML파일을 따로 생성해서 관리할 때는 
        @ConfigurationProperties(prefix = "fruit")
    */
    private List<Fruit> list;

}
