public class TwoStackQueue<Item> {

    private Stack<Item> stack1 = new Stack();
    private Stack<Item> stack2 = new Stack();

    public void enqueue(Item value) {
        //pasamos all lo que esté en stack1 a stack2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        //agregamos el nuevo item a stack1
        stack1.push(value);

        //volvemos a meter all desde stack 2, y nos queda en orden de inserción
        //ascendente para hacer pop también fácil
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public Item dequeue(){
        if (isEmpty()){
            System.out.println("queue is empty!");
            return null;
        }
        return stack1.pop();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }
}
