import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        File namesFile = new File("/home/davidcastrillon/Documentos/coursera/algorithms-I/code_implementations/social_network_connectivity/data/names.txt");
        File timeStampsFile = new File("/home/davidcastrillon/Documentos/coursera/algorithms-I/code_implementations/social_network_connectivity/data/timestamps.txt");

        System.out.println("Input quantity of data to be used: ");
        sc = new Scanner(System.in);
        int quantity = sc.nextInt();

        String[] names = new String[quantity];
        String[] timestamps = new String[quantity];

        sc = new Scanner(namesFile);
        for (int i = 0; i < names.length; i++){
            if (sc.hasNext()){
                names[i] = sc.next();
            }
        }

        sc = new Scanner(timeStampsFile);
        for (int i = 0; i < timestamps.length; i++){
            if (sc.hasNext()){
                String date = sc.next();
                String time = sc.next();
                timestamps[i] = date + " " + time;
            }
        }

        int timestampCounter = 0;
        WeightedQuickUnionFind UF = new WeightedQuickUnionFind(quantity, names);
        connected:
        for (int i = 0; i < quantity; i++){
            String p = names[i];

            for (int j = 0; j < quantity; j++){
                String q = names[j];
                if (!UF.connected(p, q) && i != j){
                    UF.union(p, q);
                    System.out.println(p + " " + q + " - " + timestamps[timestampCounter]);
                    if (UF.flag) {
                        System.out.println("All members connected: " + timestamps[timestampCounter]);
                        break connected;
                    }
                    timestampCounter++;
                }
            }

        }
    }
}