package nio;

import java.nio.file.*;

public class MoveAndCreateDirectoryExample {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("/udemy/Spring Cloud/source.txt");
        Path targetDirectory = Paths.get("/udemy/Spring Cloud/target_directory");

        try {
            // 使用 ATOMIC_MOVE 選項將源文件移動到目標目錄
            Files.move(sourcePath, targetDirectory.resolve(sourcePath.getFileName()), StandardCopyOption.ATOMIC_MOVE);

            // 使用 Files.createDirectory() 創建目標目錄
            if (!Files.isDirectory(targetDirectory)) {
                Files.createDirectory(targetDirectory);
            }

            System.out.println("文件移動和目錄創建成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

