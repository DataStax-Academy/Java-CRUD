import com.datastax.dse.driver.api.core.DseSession;
import com.datastax.oss.driver.api.core.cql.*;
import java.net.InetSocketAddress;

public class Update {
    
    public static void main(String[] args) {

        try (DseSession session = DseSession.builder()
                .addContactPoint(new InetSocketAddress(IpAddress.get(), 9042))
                .withLocalDatacenter("DC1")
                .build()) {

            session.execute(
                SimpleStatement.builder( "UPDATE killrvideo.advocates SET super_power = ? WHERE region = ? AND city = ? AND last_name = ? AND first_name = ?")
                        .addPositionalValues("wormhole time travel", "North Carolina", "Charlotte", "Veale", "Cristina")
                        .build());
        }
    }
}
