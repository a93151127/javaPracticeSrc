import java.util.Arrays;

public class ArraysMain {
    public static void main(String[] args) {
        TShirtes[] t1 = {new TShirtes("red", "L"), new TShirtes("blue", "M")};
        TShirtes[] t2 = new TShirtes[t1.length];

        // =========== 身層複製 ==========
        for(int i = 0; i < t1.length; i++){
            // 建立一個實例(有佔據記憶體)
            TShirtes tshirt = new TShirtes(t1[i].color, t1[i].size);
            // 再把這個實例給t2
            t2[i] = tshirt;
        }
        t1[0].color = "yellow";
        System.out.println(t2[0].color);

    }
}

class TShirtes{
    String color;
    String size;

    public TShirtes(String color, String size) {
        this.color = color;
        this.size = size;
    }
}