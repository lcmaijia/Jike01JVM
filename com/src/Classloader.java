package src;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，
 * 执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。
 */
public class Classloader extends ClassLoader {

    public static void main(String[] args) {

        Class<?> helloClass = new Classloader().findClass("Hello");
        try {
            Method method = helloClass.getMethod("hello");
            try {
                method.invoke(helloClass.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    protected Class<?> findClass(String name) {
        Path path = Paths.get("/JikeTime/WorkSpace/week01/Jike01JVM/com/src/files/Hello.xlass");
        byte[] bytes64 = new byte[0];
        try {
            bytes64 = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bytes64.length; i++) {
            bytes64[i] = (byte)(255 - bytes64[i]);
        }
        return defineClass(name, bytes64, 0, bytes64.length);
    }
}
