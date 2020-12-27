import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connector {

    public Connection c;
    public Statement s;

    public connector() {

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_manager", "root", "1234");
            s = c.createStatement();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
