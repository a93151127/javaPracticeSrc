package io;

import java.io.*;
import java.net.URL;

public class StreamMain {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://google.com");
        InputStream src = url.openStream();
        OutputStream dest = new FileOutputStream("D:\\tibame\\workSpace\\SpringSecurity\\JavaPractice\\src\\IO\\output1");
        IO.dump(src, dest);
    }
}

class IO {
    public static void dump(InputStream src, OutputStream dest) throws IOException {
        // 改寫為使用 BufferedInputStream 和 BufferedOutputStream, 可以減少硬碟讀取次數
        try (InputStream input = new BufferedInputStream(src);
             OutputStream output = new BufferedOutputStream(dest)) {
            byte[] data = new byte[1024];
            int length;
            while ((length = src.read(data)) != -1) {
                dest.write(data, 0, length);
            }
        }
    }
}
