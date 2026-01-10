package designpatterns;

import java.nio.charset.StandardCharsets;

/**
 * Demonstrates bit-wise swapping and string from byte array.
 */
public class Swapping {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    public static void main(String[] args) {
        int a = 5; //101
        int b = 3; //011
        
        a = a ^ b; //101^011 = 110
        b = a ^ b; //110^011 = 101
        a = a ^ b; //110^101 = 011
        
        System.out.println(a + " " + b);
        
        byte[] bytes = {72, 101, 108, 108, 111, 25, 1};
        
        String str = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(str);
    }
}
