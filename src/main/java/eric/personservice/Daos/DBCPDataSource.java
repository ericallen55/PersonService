package eric.personservice.Daos;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DBCPDataSource {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:sqlserver://UTLPG10884\\SQLEXPRESS:58310;instance=SQLEXPRESS;database=Person DB;integratedsecurity=true");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private DBCPDataSource(){ }
}