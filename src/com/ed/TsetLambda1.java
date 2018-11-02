package com.ed;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TsetLambda1 {

    List<Employees> employees= Arrays.asList(
            new Employees("张三",18,11.11),
            new Employees("李四",28,22.22),
            new Employees("王五",38,66.66),
            new Employees("赵六",78,88.88)
    );

    @Test
    public void test(){
        employees.stream()
                .filter((e)->e.getPrice()>50)
                .limit(1)
                .forEach(System.out::println);
    }
}
