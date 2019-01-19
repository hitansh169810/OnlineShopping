
package listeners;

import com.onlinestore.utils.CacheLoader;
import com.onlinestore.utils.ProductLoader;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.Logger;

@WebListener
public class ServerStartAndShutdownListener
implements ServletContextListener {
    Logger logger = Logger.getLogger(ServerStartAndShutdownListener.class);

    public void contextDestroyed(ServletContextEvent arg0) {
        CacheLoader.cleanCache();
    }

    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("SERVER START.......................");
        System.out.println("CACHE LOADING.........");
        try {
            CacheLoader.loadCache();
            System.out.println("category cache loaded ");
            ProductLoader.loadProducts();
            System.out.println("product cache loaded ");
        }
        catch (ClassNotFoundException e) {
            this.logger.debug((Object)"class not found exception inside serverstartandshutdownlistener");
        }
        catch (SQLException e) {
            this.logger.debug((Object)"SQL exception inside serverstartandshutdownlistener");
        }
        this.logger.debug((Object)"cache loaded");
    }
}