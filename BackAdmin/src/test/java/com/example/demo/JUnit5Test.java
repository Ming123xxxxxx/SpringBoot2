package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/30 9:52
 */
@DisplayName("JUnit5的测试类")
@SpringBootTest
public class JUnit5Test {

    @DisplayName("测试displayName")
    @Test
    public void  DisPlayName(){
        System.out.println("xxxx");
    }

    @DisplayName("测试方法2")
    @Test
    public void  DisPlayName2(){
        System.out.println("pppp");
    }

    //规定方法超时时间,超出规定时间则会抛出超时异常
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeOut() throws InterruptedException {
        Thread.sleep(600);
    }

    @RepeatedTest(5)
    @Test
    void Test2(){
        System.out.println("12345");
    }

    @DisplayName("测试BeforEach")
    @BeforeEach
    @Test
     void testBeforEach(){
        System.out.println("测试就要开始了");
    }

    @DisplayName("测试AfterEach")
    @AfterEach
    @Test
     void testAfterEach(){
        System.out.println("测试就要结束了");
    }

    @DisplayName("测试BeforeAll")
    @BeforeAll
    @Test
    static  void testBeforeAll(){
        System.out.println("所有测试都要开始了");
    }

    @DisplayName("测试AfterAll")
    @AfterAll
    @Test
    static void testAfterAll(){
        System.out.println("所有测试已经结束了");
    }

}
