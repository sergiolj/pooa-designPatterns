package designPatterns.builder.queryBuilder;

import java.util.ArrayList;
import java.util.List;

public class QuerySQLCreator {

    private final BDSystem bdSystem;

    private final String tableName;
    private final String tableAlias;
    private final ArrayList<String> selectColumnListOf;
    private final ArrayList<String> whereConditionListOf;


    private QuerySQLCreator(QueryBuilder queryBuilder) {
        this.bdSystem = queryBuilder.bdSystem;
        this.tableName = queryBuilder.tableName;
        this.tableAlias = queryBuilder.tableAlias;
        this.selectColumnListOf = queryBuilder.selectColumnListOf;
        this.whereConditionListOf = queryBuilder.whereConditionListOf;
    }

    public QuerySQLCreator toBuilder(QueryBuilder queryBuilder) {
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public ArrayList<String> getSelectColumnListOf() {
        return selectColumnListOf;
    }

    public ArrayList<String> getWhereConditionListOf() {
        return whereConditionListOf;
    }

    public BDSystem getBdSystem() {
        return bdSystem;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SELECT ");
        if(selectColumnListOf.size() == 1) {
            sb.append(selectColumnListOf.get(0));
        }else{
            for(int i = 0; i < selectColumnListOf.size(); i++) {
                sb.append(selectColumnListOf.get(i));
                if(i < selectColumnListOf.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append(" ");

        sb.append("FROM ").append(tableName);
        if(tableAlias != null) {
            sb.append(" AS ").append(tableAlias);
        }

        if(!whereConditionListOf.isEmpty()) {
            if(whereConditionListOf.size() == 1) {
                sb.append(" WHERE ").append(whereConditionListOf.get(0));
            }else{
                sb.append(" WHERE ");
                for(int i = 0; i < whereConditionListOf.size(); i++) {
                    sb.append(whereConditionListOf.get(i));
                    if(i < whereConditionListOf.size() - 1) {
                        sb.append(" AND ");
                    }
                }
            }
        }
        sb.append(";");
        return sb.toString();
    }

    public static class QueryBuilder implements GenericQueryBuilder {
        private BDSystem bdSystem;

        private String tableName;
        private String tableAlias;
        private final ArrayList<String> selectColumnListOf = new ArrayList<>();
        private final ArrayList<String> whereConditionListOf = new ArrayList<>();

        public QueryBuilder (String tableName, String tableAlias, BDSystem bdSystem) {
            this.tableName = tableName;
            this.tableAlias = tableAlias;
            this.bdSystem = bdSystem;
        }

        public QueryBuilder(String tableName, String tableAlias) {
                this.tableName = tableName;
                this.tableAlias = tableAlias;
        }

        public QueryBuilder(String tableName){
                this.tableName = tableName;
        }

        @Override
        public QueryBuilder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        @Override
        public QueryBuilder select(String... column) {
            if(column != null) {
                this.selectColumnListOf.addAll(List.of(column));
            }
            return this;
        }

        @Override
        public QueryBuilder where(String... condition) {
            if(condition != null) {
                this.whereConditionListOf.addAll(List.of(condition));
            }
            return this;
        }


        @Override
        public QueryBuilder alias(String tableAlias) {
            this.tableAlias = tableAlias;
            return this;
        }

        @Override
        public QueryBuilder withBDSystem(BDSystem bdSystem) {
            this.bdSystem = bdSystem;
            return this;
        }

        @Override
        public QuerySQLCreator toBuild() {
            if(this.selectColumnListOf.isEmpty()){
                this.selectColumnListOf.add("*");
            }
            if(bdSystem == null){
                this.bdSystem = BDSystem.POSTGRES;
            }
            if(tableAlias != null){
                addAlias();
            }
            String start = String.valueOf(this.bdSystem.getTableFormat().charAt(0));
            String end = String.valueOf(this.bdSystem.getTableFormat().charAt(1));
            this.tableName = start + tableName + end;
            return new QuerySQLCreator(this);
        }

        private void addAlias() {
            String aliasName = tableAlias;
            String originalValue;
            for(int i = 0; i < selectColumnListOf.size(); i++) {
                originalValue = selectColumnListOf.get(i);
                selectColumnListOf.set(i, aliasName + "." + originalValue);
            }
            for(int i = 0; i < whereConditionListOf.size(); i++) {
                originalValue = whereConditionListOf.get(i);
                whereConditionListOf.set(i, aliasName + "." + originalValue);
            }
        }

    }
}
