package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CustomFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("正在訪問目錄: " + dir);
        return FileVisitResult.CONTINUE; // 繼續訪問子目錄或文件
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("正在訪問文件: " + file);
        return FileVisitResult.CONTINUE; // 繼續訪問下一個文件
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("訪問文件失敗: " + file);
        return FileVisitResult.CONTINUE; // 繼續訪問下一個文件
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("完成對目錄的訪問: " + dir);
        return FileVisitResult.CONTINUE; // 繼續訪問下一個目錄
    }

    public static void main(String[] args) {
        Path startPath = Paths.get("/udemy/Spring Cloud");

        try {
            Files.walkFileTree(startPath, new CustomFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

