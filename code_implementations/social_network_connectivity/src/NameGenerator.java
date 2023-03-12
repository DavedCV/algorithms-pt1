import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        String path = args[0];
        File preNamesFile = new File(path);
        Scanner sc;
        String[] names = new String[60];

        try {
            sc = new Scanner(preNamesFile);
        } catch (FileNotFoundException e) {
            System.out.println("Bad file path");
            throw new RuntimeException(e);
        }

        int counter = 0;
        while(sc.hasNext()){
            if (counter < names.length){
                String nameData = sc.next();
                names[counter] = nameData.split(",")[0];
                counter++;
            }else{
                break;
            }
        }

        for (String name: names) {
            System.out.println(name);
        }
    }
}
