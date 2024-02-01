package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeExample {
    public static void main(String[] args) {
        Path startPath = Paths.get("/udemy/Spring Cloud");

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("檔案: " + file);
                    return FileVisitResult.CONTINUE; // 繼續到下一個檔案或目錄
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("目錄: " + dir);
                    return FileVisitResult.CONTINUE; // 繼續到下一個檔案或目錄
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("訪問檔案失敗: " + file);
                    return FileVisitResult.CONTINUE; // 繼續到下一個檔案或目錄
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("完成對目錄的訪問: " + dir);
                    return FileVisitResult.CONTINUE; // 繼續到下一個檔案或目錄
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

