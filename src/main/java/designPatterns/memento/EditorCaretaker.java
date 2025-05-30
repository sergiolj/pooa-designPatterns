package designPatterns.memento;

import java.util.Stack;

public class EditorCaretaker {
    private Stack<EditorMemento> savePoints = new Stack<>();

    public void save(EditorMemento currentState) {
        if(savePoints != null) {
            savePoints.push(currentState);
            System.out.println("Salving current state... \nThere is "
                    + savePoints.size() + " saving states in the stack");
        }
    }

    public EditorMemento undoState() {
        if(savePoints != null) {
            EditorMemento currentState = savePoints.pop();
            System.out.println("Undoing current state... ");
            return currentState;
        }
        System.out.println("No saving states in stack");
        return null;
    }

    public void showHistorySize() {
        System.out.println("There are " + savePoints.size() + " saving states in stack");
    }

}
