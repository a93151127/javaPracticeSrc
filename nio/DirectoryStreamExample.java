package nio;

import java.nio.file.*;
import java.io.IOException;

public class DirectoryStreamExample {
    public static void main(String[] args) {
        // 使用 newDirectoryStream() 迭代目錄內的檔案或子目錄
        Path directoryPath = Paths.get("/udemy/Spring Cloud");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {
            for (Path path : directoryStream) {
                System.out.println("檔案或目錄: " + path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用 getRootDirectories() 獲取文件系統的根目錄
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path rootDir : rootDirectories) {
            System.out.println("根目錄: " + rootDir);
        }
    }
}

