package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2022/1/30 11:25
 */

@DisplayName("嵌套测试")
public class AStack {
    Stack<Object> stack;

    @Test
    @DisplayName("创建一个栈")
    void IsInstantiatedWithNew(){
        new Stack<>();
        //嵌套测试情况下,外层的Test不能驱动内层的@BeforeEach/All或@AfterEach/All
        assertNull(stack);
    }

    @Nested
    @DisplayName("")
    class WhenNew{

        @BeforeEach
        void createNewStack(){
            stack = new Stack<>();
        }

        @Test
        @DisplayName("判断栈是否为空")
        void isEmpty(){
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("")
        void throwExceptionWhenPopped(){
            assertThrows(EmptyStackException.class,stack::pop);
        }

        @Test
        @DisplayName("")
        void throwExceptionWhenPeeked(){

            assertThrows(EmptyStackException.class,stack::peek);
        }

        @Nested
        @DisplayName("")
        class AfterPushing{

            String anElemennt = "an element";

            @BeforeEach
            void pushAnElement(){
                stack.push(anElemennt);
            }

            //嵌套测试情况下,内层的Test能驱动内层的@BeforeEach/All或@AfterEach/All
            @Test
            @DisplayName("")
            void isNotEmpty(){
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("")
            void retrunElementWhenPopped(){
                assertEquals(anElemennt,stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("")
            void returnElementWhenPeeked(){
                assertEquals(anElemennt,stack.peek());
                assertFalse(stack.isEmpty());
            }
        }

    }
}
