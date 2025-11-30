package designPatterns.builder.queryBuilder;

public enum BDSystem{
    POSTGRES("\"\""),
    SQLSERVER("[]"),
    MYSQL("``");

    private final String tableFormat;

    BDSystem(String tableFormat){
        this.tableFormat = tableFormat;
    }

    public String getTableFormat() {
        return tableFormat;
    }
}