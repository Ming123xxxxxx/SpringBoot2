package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/30 10:20
 */

@DisplayName("测试断言")
@SpringBootTest
public class AsertTest {

    Assertions assertions;

    //若前面的断言失败,后面的代码都不会执行
    @Test
    public void testAssertEquals(){
        int cal = cal(2,5);
        //相等则运行结束不会有任何提示,第一个参数为预计结果,第二个参数为实际结果,第三个参数为错误提示
        assertions.assertEquals(7,cal,"业务逻辑计算失败");

        //测试前两个参数是否为同一个对象，第三个参数为错误提示信息
        Object obj = new Object();
        assertions.assertSame(obj,obj,"两个对象不同");

        //测试前两个参数的数组中的值是否一一相等,第三个参数为错误提示信息
        assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2},"两个数组不同");

        //组合断言,都断言成功则正常运行,一个断言失败则会报错
        assertions.assertAll("test",
                ()-> assertions.assertTrue(true && true,"结果不为true"),
                ()-> assertions.assertEquals(1,1,"结果不相等"));

        //异常断言,断定一定会出现异常,若出现指定异常,则正常运行,若没出现,则会报错,
        //第一个参数为异常类型,第二个为所判断的属性,第三个为提示信息
        assertions.assertThrows(ArithmeticException.class,()->{int p=10/0;},"业务逻辑正常运行");

        //快速失败
        if(1==2){
            assertions.fail("测试失败");
        }

    }

    @DisplayName("测试前置条件")
    @Test
    public void testAssumpTions(){

        Assumptions.assumeTrue(true,"结果不是true");
        System.out.println("111111111");
    }

    int cal(int i,int j){
        return i+j;
    }
}
