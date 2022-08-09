import java.sql.SQLException;

public class Main {
    private static VoltDb voltDb = new VoltDb();
    private static OracleDb oracleDb = new OracleDb();

    public static void main(String[] args) throws SQLException {

        voltDb.createTable();
        voltDb.insert100k();
        voltDb.get100k();
        voltDb.dropTable();


        oracleDb.createTable();
        oracleDb.insert100k();
        oracleDb.get100k();
        oracleDb.dropTable();

    }
}
