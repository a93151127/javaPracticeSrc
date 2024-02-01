package nio;

import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathMethodsExample {
    public static void main(String[] args) {
        try {
            // 創建兩個路徑
            Path path1 = Paths.get("/udemy/Spring Cloud");
            Path path2 = Paths.get("/tibame/example/mywebDemo");

            // 使用 toAbsolutePath() 方法取得絕對路徑
            Path absolutePath = path1.toAbsolutePath();
            System.out.println("Absolute Path: " + absolutePath);

            // 使用 toRealPath() 方法取得實際路徑
            Path realPath = path1.toRealPath();
            System.out.println("Real Path: " + realPath);

            // 使用 resolve() 方法解析路徑(結合兩個路徑)
            Path resolvedPath = path1.resolve("file.txt");
            System.out.println("Resolved Path: " + resolvedPath);

            // 使用 relativize() 方法獲得相對路徑
            Path relativePath = path1.relativize(path2);
            System.out.println("Relative Path: " + relativePath);

            // 使用 startsWith() 和 endsWith() 方法檢查路徑開始和結尾
            boolean startsWith = path1.startsWith("/home");
            boolean endsWith = path1.endsWith("documents");
            System.out.println("Starts with /home: " + startsWith);
            System.out.println("Ends with documents: " + endsWith);

            // 使用 equals() 方法比較兩個路徑是否相等
            boolean areEqual = path1.equals(path2);
            System.out.println("Paths are equal: " + areEqual);

            // 使用 Files.isSameFile() 方法比較兩個文件是否相同
            boolean sameFile = Files.isSameFile(path1, path2);
            System.out.println("Same file: " + sameFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

