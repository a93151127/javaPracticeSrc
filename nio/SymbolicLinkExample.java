package nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class SymbolicLinkExample {
    public static void main(String[] args) {
        // 原始文件的路徑
        Path originalPath = Paths.get("/udemy/Spring Cloud/original.txt");

        // 符號連結的路徑
        Path symlinkPath = Paths.get("/udemy/Spring Cloud/symlink.txt");

        try {
            // 使用 Files.createSymbolicLink() 創建符號連結
            Files.createSymbolicLink(symlinkPath, originalPath);

            // 檢查符號連結是否存在並打印路徑
            boolean exists = Files.exists(symlinkPath);
            System.out.println("Symbolic link exists: " + exists);
            System.out.println("Symbolic link path: " + symlinkPath.toAbsolutePath());

            // 如果需要，你可以透過 Files.readSymbolicLink() 讀取符號連結指向的目標
            Path targetPath = Files.readSymbolicLink(symlinkPath);
            System.out.println("Symbolic link target: " + targetPath.toAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

