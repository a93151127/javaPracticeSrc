public class StringMain {

    public static void main(String[] args) {
        long startTimestamp = System.currentTimeMillis();
        String text = "";
        for(int i = 0 ; i <10000 ; i++){
            //每次相加繪產生一個新的記憶體
            text = text + i;
        }
        long endTimestamp = System.currentTimeMillis();
        System.out.println("spend time : " + (endTimestamp - startTimestamp) + " millseconds");

        System.out.println("==============================");

        startTimestamp = System.currentTimeMillis();
        StringBuilder textBuilder = new StringBuilder();
        for(int i = 0 ; i <10000 ; i++){
            //從頭到尾是對同一個記憶體做操作
            textBuilder.append(i);
        }

        endTimestamp = System.currentTimeMillis();
        System.out.println("spend time : " + (endTimestamp - startTimestamp) + " millseconds");
    }
}

