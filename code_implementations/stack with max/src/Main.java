public class Main {
    public static void main(String[] args) {
        stack st = new stack();
        int[] elems = {1,2,3,4,12,6,7,8,9,10};
        for (int elem : elems){
            st.push(elem);
        }

        System.out.println("El máximo elemento del stack es: " + st.returnMaximum());
    }
}