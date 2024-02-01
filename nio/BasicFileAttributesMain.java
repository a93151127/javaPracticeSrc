package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFileAttributesMain {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("/udemy/Spring Cloud/file.txt");
        BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);

        System.out.println("建立時間 : " + attrs.creationTime());
        System.out.println("最後訪問時間 : " + attrs.lastAccessTime());
        System.out.println("最後修改時間 : " + attrs.lastModifiedTime());
        System.out.println("是否是目錄 : " + attrs.isDirectory());
        System.out.println("是否是其他 : " + attrs.isOther());
        System.out.println("是常規文件 : " + attrs.isRegularFile());
        System.out.println("是符號連接 : " + attrs.isSymbolicLink());
        System.out.println("大小 : " + attrs.size());
    }
}
