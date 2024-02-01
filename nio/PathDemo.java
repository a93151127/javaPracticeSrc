package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.home"));
        System.out.println(path.toString()); // C:/Users/a9315
        System.out.println(path.getFileName()); // a9315
        System.out.println(path.getName(0)); // Users
        System.out.println(path.getNameCount()); // 2
        System.out.println(path.getParent()); // C:/Users
        System.out.println(path.getRoot());// C:/
        System.out.println("======= 使用 forEach ======");
        // 使用forEach打印
        path.forEach(System.out::println);
        System.out.println("===== 使用normalize ======");
        // 創建一個路徑
        Path path1 = Paths.get("/home/user/.././documents");

        // 使用 normalize() 方法規範化路徑
        Path normalizedPath = path1.normalize();

        // 輸出原始路徑和規範化後的路徑
        System.out.println("Original Path: " + path1);
        System.out.println("Normalized Path: " + normalizedPath);
    }
}
