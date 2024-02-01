package nio;

import java.nio.file.*;
import java.io.IOException;

public class FileOperationsExample {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("/udemy/Spring Cloud/source.txt");
        Path targetPath = Paths.get("/udemy/Spring Cloud/target.txt");

        try {
            // 使用 REPLACE_EXISTING 來替代目標檔案（如果存在的話）
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);

            // 使用 DELETE_ON_CLOSE 選項將目標檔案標記為在關閉時刪除
            Files.delete(targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

