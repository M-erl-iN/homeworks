package Homeworks._8_classInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //task1
        Class fridge = Fridge.class;
        //Modifier[] modifiers = fridge.getDeModifiers();
        Field[] fields = fridge.getDeclaredFields();
        Method[] methods = fridge.getDeclaredMethods();
        Constructor[] constructors = fridge.getDeclaredConstructors();
        Annotation[] annotations = fridge.getAnnotations();

        //1 - public, 2 - private, 4 - protected, '' - 0
        HashMap<Integer, String> modMap = new HashMap<>();
        modMap.put(0, "default");
        modMap.put(1, "public");
        modMap.put(2, "private");
        modMap.put(4, "protected");

        System.out.println("\n[--fields--]\nКоличество полей: " + fields.length);
        for (Field field: fields) {
            System.out.println(field.getName() + ": " + modMap.get(field.getModifiers()));
        } System.out.println("\n[--methods--]\nКоличество методов: " + methods.length);
        for (Method method: methods) {
            System.out.println(method.getName() + ": " + modMap.get(method.getModifiers()));
        } System.out.println("\n[--constructors--]\nКоличество конструкторов: " + methods.length);
        for (Constructor constructor: constructors) {
            System.out.println(constructor.getName() + ": " + modMap.get(constructor.getModifiers()));
        } System.out.println("\n[--annotations--]\nКоличество аннотаций: " + annotations.length);

        //task(2+3)
        Grocerie exampleGrocerie = new Grocerie("example1", 200, 60, 10, 130);
        System.out.println("\n" + JsonConverter.toJson(exampleGrocerie));
        System.out.println(JsonConverter.toJson(Grocerie.class));
    }
}
