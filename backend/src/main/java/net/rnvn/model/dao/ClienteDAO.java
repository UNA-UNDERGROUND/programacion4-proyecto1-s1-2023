package net.rnvn.model.dao;

import net.rnvn.db.QueryGen;

public class ClienteDAO {
    public ClienteDAO() {
        super();
    }

    // consultas SQL

    private static final String TABLE_NAME = "clientes";

    private static final String SQL_ADD_CLIENTE //
            = QueryGen.genInsertInto(
                    TABLE_NAME,
                    new String[] { "identificacion", "nombre", "apellido", "telefono", "correo" });
    private static final String SQL_GET_CLIENTE //
            = QueryGen.genSelectString(
                    TABLE_NAME,
                    new String[] { "identificacion", "nombre", "apellido", "telefono", "correo" },
                    new String[] { "identificacion = ?" });
}
