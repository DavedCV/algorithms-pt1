public class ResizingStackOfStrings {

    private String[] s;
    private int N;

    public ResizingStackOfStrings(){
        s = new String[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        if (N > 0 && N == s.length) resize(2*s.length);
        s[N++] = item;
    }

    public void resize(int length){
        String[] copy = new String[length];
        for (int i = 0; i < s.length; i++) copy[i] = s[i];
        s = copy;
    }

    public String pop(){
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4) resize(s.length/2);
        return item;
    }
}
