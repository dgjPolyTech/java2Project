package bookmanagement.repository;

import java.sql.*;

public class JDBCConnector {
    private static final String DRIVER_PATH = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    private static final String USER_NAME = "c##book";
    private static final String PASSWORD = "1234";

    private static Connection con;

    public static Connection getConnection(){
        // 1. jdbc 드라이버를 메모리에 로딩

        try {
            Class.forName(DRIVER_PATH);
            System.out.println("JDBC Driver Method");
            // 2. Connection
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Connection Done sucessfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not Found");
        } catch (SQLException e) {
            System.out.println("Connection Error");;
        }
        return con;
    }

    public static void resultSetTest(){
        // 3. 준비된 SQL 문을 실행할 수 있는 문장 객체 생성
        try {
            String sql  = "SELECT * from book, category where book.category = category.category_id";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                System.out.print(rs.getString("name") + " || ");
                System.out.print(rs.getString("publish"));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args){
        Connection con = getConnection();
        resultSetTest();
    }
}