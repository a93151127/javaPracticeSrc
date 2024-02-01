package nio;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;

public class FileStoreExample {
    public static void main(String[] args) {
        Path file = Paths.get("/udemy/Spring Cloud/file.txt");

        try {
            FileStore fileStore = Files.getFileStore(file);

            System.out.println("文件存儲類型: " + fileStore.type());
            System.out.println("總空間大小: " + fileStore.getTotalSpace());
            System.out.println("可用空間大小: " + fileStore.getUsableSpace());
            System.out.println("未分配空間大小: " + fileStore.getUnallocatedSpace());
            System.out.println("是否支持文件屬性: " + fileStore.supportsFileAttributeView("basic"));
            Iterable<FileStore> fileStores = FileSystems.getDefault().getFileStores();
            for (FileStore store : fileStores) {
                if (store.equals(fileStore)) {
                    System.out.println("是否支援硬連結: " + store.supportsFileAttributeView(BasicFileAttributeView.class));
                    System.out.println("是否支援符號連結: " + store.supportsFileAttributeView(FileAttributeView.class));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

