package thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Thread2Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        URL[] urls = {
            new URL("http://openhome.cc/Gossip/Encoding/"),
            new URL("http://openhome.cc/Gossip/Scala/"),
            new URL("http://openhome.cc/Gossip/JavaScript/"),
            new URL("http://openhome.cc/Gossip/Python/")
        };

        String[] fileNames = {
                "Encoding.html",
                "Scala.html",
                "JavaScript.html",
                "Python.html",
        };
        // 一般方法
        generalMethod(urls, fileNames);
        // 執行緒方法
        threadMethod(urls, fileNames);
    }

    private static void generalMethod(URL[] urls, String[] fileNames) throws IOException {
        Download download = new Download();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<urls.length; i++){
            download.dump(urls[i].openStream(), new FileOutputStream(fileNames[i]));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("一般方法總花費時間 : " + (endTime - startTime) + " 毫秒");
    }

    private static void threadMethod(URL[] urls, String[] fileNames) throws IOException {
        Download download = new Download();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<urls.length; i++){
            int index = i;
            new Thread(() ->{
                try {
                    download.dump(urls[index].openStream(), new FileOutputStream(fileNames[index]));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("執行緒方法總花費時間 : " + (endTime - startTime) + " 毫秒");
    }
}

class Download{
    void dump(InputStream src, OutputStream dest) throws IOException {
        try(src; dest){
            byte[] data = new byte[1024];
            int length;
            while((length = src.read(data)) != -1){
                dest.write(data, 0, length);
            }

        }
    }
}
