package Thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {
    public static void main(String[] args) throws MalformedURLException {
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
        ExecutorService excutor = Executors.newCachedThreadPool();

        Pages page = new Pages(urls, fileNames, excutor);
        long startTime = System.currentTimeMillis();
        page.download();
        long endTime = System.currentTimeMillis();
        // excutor.shutdownNow(); // 立刻停止
        excutor.shutdown();
        System.out.println("一般方法總花費時間 : " + (endTime - startTime) + " 毫秒");
    }
}

class Pages{
    private URL[] urls;
    private String[] fileNames;
    private Executor executor;

    public Pages(URL[] urls, String[] fileNames, Executor executor) {
        this.urls = urls;
        this.fileNames = fileNames;
        this.executor = executor;
    }

    public void download(){
        for (int i = 0; i < urls.length; i++) {
            URL url = urls[i];
            String fileName = fileNames[i];
            executor.execute(()->{
                try {
                    dump(url.openStream(), new FileOutputStream(fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void dump(InputStream src, OutputStream dest) throws IOException {
        try(src; dest){
            byte[] data = new byte[1024];
            int length;
            while((length = src.read(data)) != -1){
                dest.write(data, 0 , length);
            }
        }
    }
}
