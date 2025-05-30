package designPatterns.memento;

public class EditorOriginator {
    private String content;

    public EditorOriginator() {
        this.content = "";
    }

    public void type(String sentence){
        if(sentence.endsWith(".") || sentence.endsWith("!") || sentence.endsWith("?")){
            this.content += sentence + "\n";
        }else{
            this.content += sentence + " ";
        }
    }

    public String getContent() {
        return this.content;
    }

    public EditorMemento currentState(){
        //retorna um construtor de estado (Memento) com o conteúdo do objeto (Originator) atual
        return new EditorMemento(this.content);
    }

    public void restore(EditorMemento memento){
        if(memento != null){
            this.content = memento.getContent();
            System.out.println("Restoring editor last state...");
        }else{
            System.out.println("No editor last state to restore.");
        }
    }
}
