package designPatterns.builder.queryBuilder;

public class Main {
    public static void main(String[] args) {
        QuerySQLCreator query = new QuerySQLCreator.QueryBuilder("User")
                .select("name", "age", "height")
                .where("age >= 15", "height >=165")
                .toBuild();

    System.out.println(query);

        QuerySQLCreator query2 = new QuerySQLCreator.QueryBuilder("Student", "s")
                .select("*")
                .where("matriculado = true")
                .withBDSystem(BDSystem.SQLSERVER)
                .toBuild();

        System.out.println(query2);

        QuerySQLCreator query3 = new QuerySQLCreator.QueryBuilder("Loan")
                .alias("e")
                .where("valor > 10.0000")
                .toBuild();

        System.out.println(query3);
        System.out.println("Query 3 configurada para uso em " + query3.getBdSystem());

    }
}
