package pro;

import pro.annotations.SaveTo;
import pro.annotations.Saver;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer container = new TextContainer();
        container.setText("Hello World");
        final Class<?> cls = TextContainer.class;
        try {
            Field[] fields = cls.getDeclaredFields();
            Method[] methods = cls.getDeclaredMethods();
            for (Field field : fields) {
                if (field.isAnnotationPresent(SaveTo.class)) {
                    String path = field.getAnnotation(SaveTo.class).path();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Saver.class)) {
                            method.invoke(container,path);
                            System.out.println("Text has been saved");
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
