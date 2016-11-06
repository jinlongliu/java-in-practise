package top.onos.library.web.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Liu on 2016/11/6.
 */
public class ContextLoaderListener implements ServletContextListener {

    private static final Log logger = LogFactory.getLog(ContextLoaderListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("Context Initialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("Context destordy");
    }
}
