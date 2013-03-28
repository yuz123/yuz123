import java.io.*;


public class CollectionJava {

    /**
     * @param args
     * @throws IOException 
   
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        int i = 0;
        for (i = 0; i <= 4; i++) {
        System.out.println("Vvedite "+i+" element:");
        String line = in.readLine();
        array[i] = Integer.valueOf(line);
        System.out.println(array[i]);
        }
        System.out.println("Vvedite 4islo dlya sravneniya");
        String line = in.readLine();
        int y = Integer.valueOf(line);
        int times = 0;
        for (i = 0; i <= 4; i++) {
            System.out.println("Element #" + i + "= " + array[i]);
            if (array[i] == y) {
                System.out.println("Element #" + array[i] + " sovpadaet s vvedennim 4islom " + y);
            times++;
            }
            
            }
        System.out.println("Koli4estvo sovpadeniy = " + times);
        System.out.println();
    }
      


}
