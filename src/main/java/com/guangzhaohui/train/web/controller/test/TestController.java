package com.guangzhaohui.train.web.controller.test;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 李晨辉
 * @date 2020-03-10
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("t1")
    public Object t1() {
        TestDO<TestDO> testDO = new TestDO<>();
        testDO.setDevice("1");
        testDO.setPeople("2");
        testDO.setValue("3");
        TestDO testDO2 = new TestDO();
        testDO2.setDevice("device2");
        testDO.setMore(testDO2);
        return testDO;
    }

    @GetMapping("t2")
    public Object t2() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<TestDO<TestDO>> exchange = restTemplate.exchange("http://127.0.0.1:8087/test/t1", HttpMethod.GET, entity, new ParameterizedTypeReference<TestDO<TestDO>>() {
        });
        if (exchange != null) {
            TestDO<TestDO> test = exchange.getBody();
            TestDO more = test.getMore();
            String device = more.getDevice();
            return device;
        }
        return exchange;
    }


}
