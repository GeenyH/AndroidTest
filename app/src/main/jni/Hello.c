//
// Created by QUNZHI on 2018/2/7.
//
#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

jstring  Java_net_xinglian_myapplication_JavaJNI_sayHello(JNIEnv* env, jobject thiz)
{
    return (*env)->NewStringUTF(env, "HelloWorld! I am from JNI !");
}
