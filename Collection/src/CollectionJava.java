import java.io.*;


public class CollectionJava {

    /**
     * @param args
     * @throws IOException 
   
     */
    public static void main(String[] args) throws IOException {
        
        int[] array = new int[5];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       try{
            System.out.println("Fill, show, include");
            String line = in.readLine();
            switch (line) {
            case "f":
                Stroka.fill(array);
                break;
            case "s":
                Stroka.show(array);
                break;
            case "i":
                Stroka.includeTimes(array);
                break;
            default:
                System.out.println("Wrong! reenter");
                break;
            } 
    }
    catch(NumberFormatException ne){
    System.out.println(ne.getMessage() + " is not a numeric value.");
    System.exit(0);
    }
            
       // 
        System.out.println();
    }
  
    public static class Stroka {
        
        static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        public static int[] fill(int[] array) throws IOException {
            for (int i = 0; i <= 4; i++) {
                System.out.printf("Vvedite %d element:", i);
                String line = in.readLine();
                array[i] = Integer.valueOf(line);
                System.out.println(array[i]);
                }
            return array;
        }
        
        public static void show(int[] array) {
            for (int i = 0; i <= 4; i++) {
                System.out.printf("Element #%d = %d%n", i, array[i]);
            }
        }
        public static void includeTimes(int[] array) throws IOException {
            int times = 0;
            System.out.println("Vvedite 4islo dlya sravneniya");
            String line = in.readLine();
            int y = Integer.valueOf(line);
            for (int i = 0; i <= 4; i++) {
              System.out.printf("Element #%d = %d%n", i, array[i]);
              if (array[i] == y) {
                  System.out.printf("Element #%d sovpadaet s vvedennim 4islom %d", array[i], y);
              times++;              
              }  
        }
            System.out.println("Koli4estvo sovpadeniy = " + times);
        }
    }      
  }