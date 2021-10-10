package java.lang;

/**
 * 根据jdk的双亲委派机制，在委托到引导类加载器时，找到了java.lang.String的同名类，直接使用了rt.jar的String类导致程序报错，找不到main方法
 */
public class String {
    public static void main(String[] args) {
        System.out.println("可以加载我吗？");
    }
}
