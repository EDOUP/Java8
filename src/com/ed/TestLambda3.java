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

    //用于处理字符串
    public String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }

    @Test
    public void test2(){
        String trimStr = strHandler("\t\t\t  去除首尾空格 ", (str) -> str.trim());
        System.out.println(trimStr);

        String upper = strHandler("abc", (str) -> str.toUpperCase());
        System.out.println(upper);
    }


    //对两个Long型数据进行处理
    public void op(Long l1,Long l2,MyFunction2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }

    @Test
    public void Test3(){
        op(100L,200L,(x,y)->x+y);
        op(100L,200L,(x,y)->x*y);
    }
}
