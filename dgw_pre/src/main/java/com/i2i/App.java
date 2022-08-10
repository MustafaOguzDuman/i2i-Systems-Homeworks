package com.i2i;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{


    public static final Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args ) throws IOException {
        //BasicConfigurator.configure();

        Properties props = new Properties();
        props.load(App.class.getClassLoader()
                .getResourceAsStream("log4j.xml"));
        PropertyConfigurator.configure(props);

        MSISDNGenerator msisdnGenerator = new MSISDNGenerator();
        LocationGenerator locationGenerator = new LocationGenerator();
        ServiceGenerator serviceGenerator = new ServiceGenerator();
        AmountGenerator amountGenerator = new AmountGenerator();
        while(true) {
            logger.info("MSISDN: " + msisdnGenerator.getMsisdn());
            logger.warn("Location: " + locationGenerator.getLocation());
            logger.error("Service: " + serviceGenerator.getService());
            logger.fatal("Amount: " + amountGenerator.getAmount());
        }
    }
}
