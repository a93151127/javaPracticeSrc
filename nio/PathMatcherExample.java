package nio;

import java.nio.file.*;

public class PathMatcherExample {
    public static void main(String[] args) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");

        Path filePath1 = Paths.get("/udemy/Spring Cloud/File1.java");
        Path filePath2 = Paths.get("/udemy/Spring Cloud/test/File2.java");
        Path nonJavaFilePath = Paths.get("/udemy/Spring Cloud/File3.txt");

        if (matcher.matches(filePath1)) {
            System.out.println(filePath1 + " 符合模式");
        } else {
            System.out.println(filePath1 + " 不符合模式");
        }

        if (matcher.matches(filePath2)) {
            System.out.println(filePath2 + " 符合模式");
        } else {
            System.out.println(filePath2 + " 不符合模式");
        }

        if (matcher.matches(nonJavaFilePath)) {
            System.out.println(nonJavaFilePath + " 符合模式");
        } else {
            System.out.println(nonJavaFilePath + " 不符合模式");
        }
    }
}

