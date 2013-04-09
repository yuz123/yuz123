import java.util.ArrayList;
import java.util.Scanner;

public class ab {

    public static void main(String[] args) {
        Scanner asc = new Scanner(System.in);
        ArrayList<Object> array = new ArrayList<Object>();
        System.out.println("0");
        String a = asc.next();
        System.out.println("1");
        while (asc.hasNext()) {
            array.add(asc.nextDouble()); 
           // System.out.println(array.get(2));
        }
        for (int i = 0; i <= array.size()-1; i++) {
            System.out.println(array.get(i));
        }
        /*System.out.println(a);
        String b = asc.next();
        System.out.println(b);
        b = asc.next();
        System.out.println(b);
        b = asc.next();
        System.out.println(b);
        b = asc.next();
        System.out.print(b);
        
        array.add(asc.nextDouble());*/
        asc.close();
    }
}
