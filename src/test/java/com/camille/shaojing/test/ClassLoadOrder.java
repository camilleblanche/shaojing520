package com.camille.shaojing.test;

/**
 * 当加载类对象时，首先初始化静态属性，然后执行静态块。
 * 当实例化对象时，首先执行构造块（类中的代码块），然后执行构造方法。
 * 各静态块和静态属性初始化按代码的先后顺序执行。
 * 属性、构造块（实例块）、构造方法之间的执行顺序（但构造块一定会在构造方法前执行），也是按代码的先后顺序。
 * @author lichaozhong
 * @date 2018-03-29
 */
public class ClassLoadOrder {
	public static void main(String[] args) {
		 new B();
		 System.out.println("-------------");
	     new B();
	}
}
class A {
    static {
        System.out.println("A的静态块");
    }
    private static String staticStr = getStaticStr();
    private String str = getStr();
    {
        System.out.println("A的实例块");
    }
    public A() {
        System.out.println("A的构造方法");
    }
    private static String getStaticStr() {
        System.out.println("A的静态属性初始化");
        return null;
    }
    private String getStr() {
        System.out.println("A的实例属性初始化");
        return null;
    }
}
class B extends A{
    private static String staticStr = getStaticStr();
    static {
        System.out.println("B的静态块");
    }
    {
        System.out.println("B的实例块");
    }
    public B() {
        System.out.println("B的构造方法");
    }
    private String str = getStr();
    private static String getStaticStr() {
        System.out.println("B的静态属性初始化");
        return null;
    }
    private String getStr() {
        System.out.println("B的实例属性初始化");
        return null;
    }
}

