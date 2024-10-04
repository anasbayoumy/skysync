package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database extends functions {

    private String url  = "jdbc:mysql://localhost/skysync";
    private String user = "root";
    private String pass = "";
    private Connection con; 
    private Statement stmt;

    public Database() throws SQLException {
       
        con = DriverManager.getConnection(url, user, pass); 
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        //==============================
        setStmt(stmt);
    }

    public Statement getStmt() {
        return stmt;
    }
}

