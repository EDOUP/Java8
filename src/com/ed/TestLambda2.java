package com.ed;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * Lambda表达式需要“函数式接口”的支持
 * 函数式接口：接口中只能有一个抽象方法。可以使用@FunctionalInterface修饰，检查
 */
public class TestLambda2 {

    /**
     * 无参无返回值lambda
     */
    @Test
    public void test1(){
        int num=0;
        Runnable r= new Runnable(){

            @Override
            public void run() {
                System.out.println("hello,word"+num);
            }
        };
        r.run();

        System.out.println("----------------------------");
        Runnable r1=()-> System.out.println("Helllo,无参lambda！");
        r1.run();
    }

    /**
     * 有一个参数，无返回值lambda
     * 只有一个参数小括号可以不写
     * x-> System.out.println(x)
     */
    @Test
    public void Test2(){
        Consumer<String> con=(x)-> System.out.println(x);
        con.accept("有一个参数，无返回值lambda");
    }
    /**
     * 类型推断
     * lambda 表达式的参数列表的数据类型可以省略不写，
     */
    @Test
    public void  test3(){
        Comparator<Integer> con=(x,y)->{
            System.out.println("接收两个参数的函数式接口");
            return Integer.compare(x,y);
        };
    }

    /**
     * lambda只有一条语句，return 和大括号可以省略不写
     */
    @Test
    public void  test4(){
        Comparator<Integer> con=(x,y)->Integer.compare(x,y);
    }

    /**
     * 类型推断
     */
    @Test
    public void test5(){
        //普通
        List<String> list = new ArrayList<>();
        //java1.8
        show(new HashMap<>());
    }


    public void show(Map<String ,Integer> map){

    }

    @Test
    public void test6(){
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
    }

    public Integer operation(Integer num,MyFun mf){
        return mf.getValue(num);
    }

}
