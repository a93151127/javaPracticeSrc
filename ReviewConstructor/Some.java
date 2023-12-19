package ReviewConstructor;

import java.util.ArrayList;
import java.util.List;

public class Some {
    public Some() {
        List<String> list = new ArrayList<>();
        System.out.println("inside Some");
    }

    public Some(int i){
        System.out.println("inside int i : " + i);
    }
}
