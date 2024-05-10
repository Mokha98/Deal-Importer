import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DealDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ClusteredDH_Db";
    private static final String USER = "ClusteredDH";
    private static final String PASSWORD = "ClusteredDH";
    private static final Logger logger = Logger.getLogger(DealValidator.class.getName());

    public void saveDeal(Deal deal) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql =
                    "INSERT INTO deals (deal_unique_id, from_currency_iso_code, to_currency_iso_code, deal_timestamp, deal_amount) VALUES (?, ?, ?, ?, ?)";
            ExecuteInsertDeal(deal, conn, sql);
        } catch (SQLException e) {
            LogSQLException( e);
        }
    }

    private void ExecuteInsertDeal(Deal deal, Connection conn, String sql) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, deal.getDealUniqueId());
            pstmt.setString(2, deal.getFromCurrencyISOCode());
            pstmt.setString(3, deal.getToCurrencyISOCode());
            pstmt.setLong(4, deal.getDealTimestamp());
            pstmt.setDouble(5, deal.getDealAmount());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            LogSQLException( e);
        }
    }

    public void saveDeals(Collection<Deal> deals) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            String sql =
                    "INSERT INTO deals (deal_unique_id, from_currency_iso_code, to_currency_iso_code, deal_timestamp, deal_amount) VALUES (?, ?, ?, ?, ?)";


            for (Deal deal : deals)
            {
                ExecuteInsertDeal(deal, conn, sql);
            }


        } catch (SQLException e) {
            LogSQLException( e);

        }
    }

    public boolean doesDealExist(String dealUniqueId) {
        boolean dealExists = false;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT COUNT(*) FROM deals WHERE deal_unique_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, dealUniqueId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1);
                        dealExists = count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            LogSQLException( e);
        }
        return dealExists;
    }

    private void LogSQLException(SQLException e)
    {
        String message;

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String sStackTrace = sw.toString();

        message = "Date Time: " + LocalDateTime.now().toString() +
                "\n" + "Message: " + e.getMessage() +
                "\n" + "ErrorCode: " + e.getErrorCode() +
                "\n" + "StackTrace: " + sStackTrace;


        logger.log(Level.SEVERE, message);

    }
}
