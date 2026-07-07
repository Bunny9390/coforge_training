import com.coforge.ems.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TempCheck {
    public static void main(String[] args) throws Exception {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) AS cnt FROM employee");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                System.out.println("Row count in current DB table: " + rs.getInt("cnt"));
            }
        }
    }
}
