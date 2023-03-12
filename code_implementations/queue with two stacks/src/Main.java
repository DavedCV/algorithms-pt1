public class Main {
    public static void main(String[] args) {
        TwoStackQueue tsq = new TwoStackQueue();
        int[] elem = {1};
        for (int i = 0; i < elem.length; i++){
            tsq.enqueue(elem[i]);
        }

        System.out.println("desencolamos los dos primeros");
        for(int i = 0; i < 2; i++){
            System.out.println("Sale " + tsq.dequeue());
        }

        System.out.print("lista final: [ ");
        while(!tsq.isEmpty()){
            System.out.print(tsq.dequeue() + " ");
        }
        System.out.println("]");
    }
}