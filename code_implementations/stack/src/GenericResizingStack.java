import java.util.Iterator;

public class GenericResizingStack<Item> implements Iterable<Item>{
    private Item[] s;
    private int N;

    public GenericResizingStack(){
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(Item item){
        if (N > 0 && N == s.length) resize(2*s.length);
        s[N++] = item;
    }

    public void resize(int length){
        Item[] copy = (Item[]) new Object[length];
        for (int i = 0; i < s.length; i++) copy[i] = s[i];
        s = copy;
    }

    public Item pop(){
        Item item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4) resize(s.length/2);
        return item;
    }

    public Iterator<Item> iterator(){
        return new reverseArrayIterator();
    }

    private class reverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return s[--i];
        }
    }
}
