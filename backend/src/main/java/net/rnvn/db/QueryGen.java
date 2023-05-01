package net.rnvn.db;

// this class is used to generate several SQL prepared statements
public class QueryGen {
    private QueryGen() {
    }

    public static String genInsertInto(String table, String[] columns) {
        String query = "insert into " + table + " (";
        for (int i = 0; i < columns.length; i++) {
            query += columns[i];
            if (i < columns.length - 1) {
                query += ", ";
            }
        }
        query += ") values (";
        for (int i = 0; i < columns.length; i++) {
            query += "?";
            if (i < columns.length - 1) {
                query += ", ";
            }
        }
        query += ")";
        return query;
    }

    public static String genSelectString(String table, String[] columns, String[] conditions) {
        String query = "select ";
        for (int i = 0; i < columns.length; i++) {
            query += columns[i];
            if (i < columns.length - 1) {
                query += ", ";
            }
        }
        query += " from " + table + " where ";
        for (int i = 0; i < conditions.length; i++) {
            query += conditions[i];
            if (i < conditions.length - 1) {
                query += " and ";
            }
        }
        return query;
    }

    public static String genUpdateString(String table, String[] columns, String[] conditions) {
        String query = "update " + table + " set ";
        for (int i = 0; i < columns.length; i++) {
            query += columns[i] + " = ?";
            if (i < columns.length - 1) {
                query += ", ";
            }
        }
        query += " where ";
        for (int i = 0; i < conditions.length; i++) {
            query += conditions[i];
            if (i < conditions.length - 1) {
                query += " and ";
            }
        }
        return query;
    }

    public static String genDeleteString(String table, String[] conditions) {
        String query = "delete from " + table + " where ";
        for (int i = 0; i < conditions.length; i++) {
            query += conditions[i];
            if (i < conditions.length - 1) {
                query += " and ";
            }
        }
        return query;
    }

    public static String genCallStoredProcedure(String procedureName, String[] parameters) {
        String query = "{ call " + procedureName + " (";
        for (int i = 0; i < parameters.length; i++) {
            query += "?";
            if (i < parameters.length - 1) {
                query += ", ";
            }
        }
        query += ") }";
        return query;
    }
}
