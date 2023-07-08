package Alpha;

import org.apache.logging.log4j.*;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Demo
{
    static Logger log = LogManager.getLogManager().getLogger("Demo");
    // Initialising the LogManager class same as we do for WebDriver, here the getLogger method accepts class argument so we
    // have to pass class name
    // LogManager is a static class
    public static void main(String[] args)
    {
        log.debug("I am debugging");
        log.info("Obj is present");
        log.error("Obj is not present");
        log.fatal("this is fatal");
    }
}
