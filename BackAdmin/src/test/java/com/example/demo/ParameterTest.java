package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/31 9:07
 */

@DisplayName("参数化测试")
public class ParameterTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void testpara(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @MethodSource("stringProvide")
    void testmethod(String i){
        System.out.println(i);
    }

    static Stream<String> stringProvide(){
        return Stream.of("apple","banana","tomoto");
    }

}
