package designPatterns.command.menuConsole.collections;

public class NodeD<T> {
    private T data;
    private NodeD<T> next;
    private NodeD<T> prev;

    public NodeD(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public NodeD<T> getPrev() {
        return prev;
    }

    public void setPrev(NodeD<T> prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public NodeD<T> getNext() {
        return next;
    }
    public void setNext(NodeD<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeD{" +
                "data=" + data +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
