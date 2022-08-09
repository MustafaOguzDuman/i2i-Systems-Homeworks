import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleDb {
    private static DbHelper dbHelper = new DbHelper("system", "oracle", "jdbc:oracle:thin:@localhost:49161:xe");
    private static Subscriber subscriber = new Subscriber();
    private static Connection connection;
    private static PreparedStatement statement;

    static {
        try {
            connection = dbHelper.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insert100k() throws SQLException {
        String sql = "INSERT INTO SUBSCRIBERS (telNo, packageName, usage, remainingUsage)" +
                "values(?,?,?,?)";
        statement = connection.prepareStatement(sql);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int remainingUsage = 5000 - subscriber.randomUsage();
            statement.setString(1, subscriber.randomTelNo());
            statement.setString(2, subscriber.getPackageName());
            statement.setInt(3, subscriber.randomUsage());
            statement.setInt(4, remainingUsage);
            statement.executeUpdate();
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("||OracleDB|| INSERT time of 100K data : " + totalTime + "ms");
    }

    public static void get100k() throws SQLException {

        String sql = "SELECT * FROM NUMBERS WHERE rownum <=100000";
        statement = connection.prepareStatement(sql);
        long startTime = System.currentTimeMillis();
        statement.executeUpdate();
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("||OracleDB|| SELECT time of 100K data : " + totalTime + "ms");
    }

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE Subscribers " +
                "(telNo varchar(15), packageName varchar(35), usage int, remainingUsage int)";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("Table is created.");
    }

    public static void dropTable() throws SQLException {
        String sql = "DROP TABLE subscribers";
        statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("Table is dropped.");
    }
}



