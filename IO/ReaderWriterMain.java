package IO;

import java.io.*;
import java.net.URL;

public class ReaderWriterMain {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://google.com");
        FileReader reader = new FileReader("D:\\tibame\\workSpace\\SpringSecurity\\JavaPractice\\src\\IO\\output1");
        StringWriter writer = new StringWriter();
        IO2.dump(reader, writer);
        System.out.println(writer.toString());
    }
}

class IO2 {
    public static void dump(Reader src, Writer dest) throws IOException {
        // 改寫為使用 BufferedInputStream 和 BufferedOutputStream, 可以減少硬碟讀取次數
        try (src; dest) {
            char[] data = new char[1024];
            int length;
            while((length = src.read(data)) != -1){
                dest.write(data, 0, length);
            }
        }
    }
}
