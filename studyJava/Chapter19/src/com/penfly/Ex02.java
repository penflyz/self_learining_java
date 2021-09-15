package com.penfly;

import javax.sound.midi.SoundbankResource;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author  Penflyz
 * @time  2021/9/1 16:11
 */
 
public class Ex02 {


 public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
   Class<?> aClass = Class.forName("java.io.File");

  Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
  for (Constructor<?> declaredConstructor : declaredConstructors) {
   System.out.println(declaredConstructor);
  }

  Constructor<?> constructor = aClass.getConstructor(String.class);
  String path = "d:\\desktop\\qq.txt";
  Object o = constructor.newInstance(path);
  Method createNewFile = aClass.getMethod("createNewFile");
  createNewFile.invoke(o);


 }
}
