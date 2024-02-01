package nio;

import java.nio.ByteBuffer;

public class BufferExample {
    public static void main(String[] args) {
        // 創建一個 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // 填充一些數據到緩衝區
        for (int i = 0; i < 4; i++) {
            if(i == 2){
                // 做標記 (mark)
                buffer.mark();
            }
            buffer.put((byte) i);
        }


        // 查詢緩衝區中的剩餘元素數
        System.out.println("Remaining elements after marking: " + buffer.remaining());

        // 列印緩衝區中的元素
        System.out.print("Buffer elements: ");
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
        System.out.println();  // 換行

        // 重置 (reset) 到標記點
        buffer.reset();

        // 再次查詢緩衝區中的剩餘元素數
        System.out.println("Remaining elements after resetting: " + buffer.remaining());

        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
    }
}

