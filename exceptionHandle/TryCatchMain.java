package exceptionHandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchMain {
    public static void main(String[] args) throws Exception {
        int a = Long.compare(99, 100);
        System.out.println(a);
    }

   public static void a(){
        throw new IllegalArgumentException();
   }

   public static void b(){
        throw new NullPointerException();
   }
}
