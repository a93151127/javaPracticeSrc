package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryStreamFilterExample {
    public static void main(String[] args) {
        Path directoryPath = Paths.get("/udemy/Spring Cloud");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath, new DirectoryFilter())) {
            for (Path path : directoryStream) {
                System.out.println("資料夾: " + path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class DirectoryFilter implements DirectoryStream.Filter<Path> {
        @Override
        public boolean accept(Path entry) throws IOException {
            return Files.isDirectory(entry);
        }
    }
}

