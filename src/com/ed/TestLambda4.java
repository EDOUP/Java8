package com.ed;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内置四大核心函数式接口
 * Consumer<T>:消费型接口
 *      void accept(T t)
 * Supplier<T>:供给型接口
 *      T get();
 * Function(T,R):函数型接口
 *      R apply(T t);
 * Predicate<T>:断言型接口
 *      boolean test(T t);
 */

public class TestLambda4 {
    //Consumer<T>:消费型接口
    //   void accept(T t)
    @Test
    public void test1(){
        happy(100,x-> System.out.println("消费型接口"+x+"元"));
    }

    public  void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    //Supplier<T>:供给型接口
    //  T get();
    @Test
    public void Test2(){
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
        numList.forEach(System.out::println);
    }

    //产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list=new ArrayList<>();

        for (int i = 0; i <num ; i++) {
            Integer n=sup.get();
            list.add(n);
        }

        return list;
    }

    //Function(T,R):函数型接口
    //  R apply(T t);
    @Test
    public void test3(){
        String subStr = strHandler("\t\t\t 函数型接口去除空格 ", (str) -> str.trim());
        System.out.println(subStr);
    }

    //处理字符串
    public  String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    //Predicate<T>:断言型接口
    //   boolean test(T t);
    @Test
    public void test4(){
        List<String> list= Arrays.asList("Hello","java","8");
        List<String> strList = filter(list, (s) -> s.length() > 3);
        strList.forEach(System.out::println);
    }

    public List<String> filter(List<String> list, Predicate<String> pre){
        List<String> strList=new ArrayList<>();
        for(String str :list){
            if(pre.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }
}
