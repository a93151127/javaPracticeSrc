package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class NioMain {
    public static void main(String[] args) throws IOException {
        // 傳統方法
        InputStream src = new FileInputStream("src\\nio\\WWW.txt");
        OutputStream dest = new FileOutputStream("src\\nio\\abc.txt");
        dump(src, dest);

        // NIO 方法
        InputStream srcNio = new FileInputStream("src\\nio\\NIONIO.txt");
        OutputStream destNio = new FileOutputStream("src\\nio\\nioDest.txt");
        ReadableByteChannel readSrc = Channels.newChannel(srcNio);
        WritableByteChannel writeDest = Channels.newChannel(destNio);
        dumpByNio(readSrc, writeDest);

    }
    private static void dump(InputStream src, OutputStream dest) throws IOException {
        try(src; dest){
            byte[] data = new byte[1024];
            int length;
            while((length = src.read(data)) != -1){
                dest.write(data, 0, length);
            }
        }
    }

    /**
     * 使用 NIO 寫入資料
     * @param src
     * @param dest
     * @throws IOException
     */
    private static void dumpByNio(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try(src; dest){
            while(src.read(buffer) != -1){
                // 開始標記
                buffer.flip();
                // 開始寫入
                dest.write(buffer);
                // 清除標記
                buffer.clear();
            }
        }
    }
}
