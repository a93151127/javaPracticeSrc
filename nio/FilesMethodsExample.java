package nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesMethodsExample {
    public static void main(String[] args) {
        try {
            // 創建一個路徑
            Path filePath = Paths.get("/udemy/Spring Cloud/file.txt");

            // 使用 Files.exists() 檢查文件是否存在
            boolean exists = Files.exists(filePath);
            System.out.println("File exists: " + exists);

            // 使用 Files.notExists() 檢查文件是否不存在
            boolean notExists = Files.notExists(filePath);
            System.out.println("File does not exist: " + notExists);

            // 使用 Files.isExecutable() 檢查文件是否可執行
            boolean isExecutable = Files.isExecutable(filePath);
            System.out.println("File is executable: " + isExecutable);

            // 使用 Files.isHidden() 檢查文件是否為隱藏文件
            boolean isHidden = Files.isHidden(filePath);
            System.out.println("File is hidden: " + isHidden);

            // 使用 Files.isReadable() 檢查文件是否可讀
            boolean isReadable = Files.isReadable(filePath);
            System.out.println("File is readable: " + isReadable);

            // 使用 Files.isRegularFile() 檢查是否為普通文件 (非目錄或符號連結)
            boolean isRegularFile = Files.isRegularFile(filePath);
            System.out.println("Is a regular file: " + isRegularFile);

            // 使用 Files.isSymbolicLink() 檢查是否為符號連結
            boolean isSymbolicLink = Files.isSymbolicLink(filePath);
            System.out.println("Is a symbolic link: " + isSymbolicLink);

            // 使用 Files.isWritable() 檢查文件是否可寫
            boolean isWritable = Files.isWritable(filePath);
            System.out.println("File is writable: " + isWritable);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

