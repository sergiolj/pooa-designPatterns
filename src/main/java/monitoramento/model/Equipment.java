package monitoramento.model;

public abstract class Equipment {
    private static int count = 0;
    private String description;
    private final int id;

    public Equipment() {
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
