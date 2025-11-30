package designPatterns.builder.queryBuilder;

import java.util.List;

public interface GenericQueryBuilder {
    GenericQueryBuilder tableName(String tableName);

    QuerySQLCreator.QueryBuilder select(String... column);

    QuerySQLCreator.QueryBuilder where(String... condition);

    GenericQueryBuilder alias(String tableAlias);

    GenericQueryBuilder withBDSystem(BDSystem bdSystem);

    QuerySQLCreator toBuild();
}
