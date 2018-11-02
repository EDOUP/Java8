package com.ed;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda3 {

    List<Employees> emps = Arrays.asList(
            new Employees("张三",38,11.11),
            new Employees("李四",28,22.22),
            new Employees("王五",18,66.66),
            new Employees("赵六",78,88.88)
    );

    @Test
    public void test1(){
        Collections.sort(emps,(e1,e2)->{
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for(Employees emp:emps){
            System.out.println(emp);
        }
    }
}
