import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Scanner;

public class TimeStampGenerator {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int M = sc.nextInt();
        Timestamp[] timestamps = new Timestamp[M];

        long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
        long diff = end - offset + 1;

        for (int i = 0; i < M; i++){
            Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
            timestamps[i] = rand;
        }

        Arrays.sort(timestamps);

        for (Timestamp timestamp : timestamps){
            System.out.println(timestamp.toString());
        }

    }
}
