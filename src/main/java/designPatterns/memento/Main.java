package designPatterns.memento;

public class Main {
    public static void main(String[] args) {
        EditorOriginator editor = new EditorOriginator();
        EditorCaretaker history = new EditorCaretaker();

        editor.type("Ola, adivinha quem?");
        history.save(editor.currentState());

        System.out.println("Actual content: " + editor.getContent());
        System.out.println("----");

        editor.type("Mundo!!! Acertou!!");
        history.save(editor.currentState());
        System.out.println("Actual content: " + editor.getContent());
        System.out.println("----");

        editor.type("Como você adivinhou? Posso saber?");
        System.out.println(editor.getContent());
        history.save(editor.currentState());

        editor.type("Achei muito inteligente de sua parte,");
        history.save(editor.currentState());
        System.out.println("Actual content: " + editor.getContent());
        System.out.println("----");
        editor.type("mas me diga uma coisa, como você descobriu?");
        System.out.println(editor.getContent());
        history.save(editor.currentState());

        editor.restore(history.undoState());
        editor.restore(history.undoState());

        System.out.println("Actual content: " + editor.getContent());
        history.showHistorySize();
        editor.restore(history.undoState());
        System.out.println("Actual content: " + editor.getContent());

    }
}
