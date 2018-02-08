package net.xinglian.myapplication;

/**
 * Created by QUNZHI on 2018/2/7.
 */

public class JavaJNI {

    static {
        System.loadLibrary("Hello");
    }
    public native String sayHello();
}