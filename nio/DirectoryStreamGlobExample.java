package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryStreamGlobExample {
    public static void main(String[] args) {
        Path directoryPath = Paths.get("/udemy/Spring Cloud");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath, "*.{class,jar}")) {
            for (Path path : directoryStream) {
                System.out.println("搜尋到的檔案: " + path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

