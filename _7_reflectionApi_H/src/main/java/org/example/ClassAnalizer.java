package org.example;

import java.util.Arrays;

public class ClassAnalizer {
    public static void analizeClass(Object o){
        Class clazz = o.getClass();
        System.out.println("Имя класса: " + clazz);
        System.out.println("Количество полей класса: " + clazz.getDeclaredFields().length);
        System.out.println("Поля класса: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Количество методов класса: " +  clazz.getDeclaredMethods().length);
        System.out.println("Поля класса: " + Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Количество конструкторов класса: " + clazz.getConstructors().length);
        System.out.println("Конструкторы класса: " + Arrays.toString(clazz.getConstructors()));

    }
    public static void main(String[] args) {

        analizeClass(new Songs("Пришла весна", 10000, "Soltwine"));
    }
}
