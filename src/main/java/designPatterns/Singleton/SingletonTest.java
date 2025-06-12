package Singleton;

public class SingletonTest {
    public static void main(String[] args) {
        LazySingleton s1 = LazySingleton.getInstance();
        LazySingleton s2 = LazySingleton.getInstance();
        System.out.println(s1 == s2);
        s1.sayHello();
        s2.sayHello();


    }
}
