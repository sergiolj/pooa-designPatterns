package designPatterns.command.menuConsole.collections;

public class MyListaDuplaEncadeada<T>  implements ListaDuplaInterface<T> {
    NodeD<T> head;
    NodeD<T> tail;
    int size=0;

    public MyListaDuplaEncadeada() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null && size==0;
    }

    @Override
    public boolean adicionarInicio(T elemento) {
        if(isEmpty()){
            addAtBeginnig(elemento);
            return true;
        }else{
            NodeD<T> newNode = new NodeD<>(elemento);
            newNode.setNext(head);
            this.head.setPrev(newNode);
            this.head = newNode;
            size++;
        }
        return true;
    }

    @Override
    public boolean adicionarFim(T elemento) {
        if(isEmpty()){
            addAtBeginnig(elemento);
            return true;
        }else{
            NodeD<T> newNode = new NodeD<>(elemento);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
        return true;
    }

    private void addAtBeginnig(T elemento) {
        NodeD<T> newNode = new NodeD<>(elemento);
        this.tail = newNode;
        this.head = newNode;
        size++;
    }

    @Override
    public boolean removerFim() {
        if(isEmpty()){
            System.out.println("Impossível remover, lista vazia");
            return false;
        }
        if(head == tail){
            this.head = null;
            this.tail = null;
            size--;
            return true;
        }
        this.tail = tail.getPrev();
        this.tail.setNext(null);
        size--;
        return true;
    }

    @Override
    public boolean removerInicio() {
        if(isEmpty()){
            System.out.println("Impossível remover, lista vazia");
            return false;
        }
        if(head == tail){
            this.head = null;
            this.tail = null;
            size--;
            return true;
        }
        this.head = head.getNext();
        this.head.setPrev(null);
        size--;
        return true;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean contains(T elemento) {
        if(isEmpty()){
            return false;
        }
        NodeD<T> node = head;
        while(node!=null){
            if(elemento.equals(node.getData())){
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public T get(int index) {
        int currentIndex = 0;
        if(isEmpty()){
            return null;
        }else{
            NodeD<T> node = head;
            while(node!=null){
                if(index==currentIndex){
                    return node.getData();
                }
                currentIndex++;
                node = node.getNext();
            }
        }
        return null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public String toString() {
        if(isEmpty()){
            return "{}";
        }
        StringBuilder str = new StringBuilder("{");
        NodeD<T> current = head;
        while (!current.equals(tail)){
            str.append(current.getData()).append(", ");
            current = current.getNext();
        }
        str.append(current.getData()).append("}");
        return str.toString();
    }
}
