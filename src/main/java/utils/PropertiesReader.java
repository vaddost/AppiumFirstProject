package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class PropertiesReader {
    private String remoteHost;
    private String remotePath;
    private String remotePort;

    static Logger logger = LogManager.getLogger(PropertiesReader.class);

    private static PropertiesReader propertiesReader;

    private PropertiesReader(){
        Properties prop = new Properties();
        try(FileInputStream reader = new FileInputStream("src/main/resources/config.properties")){
            prop.load(reader);
            remoteHost = prop.getProperty("appium.host");
            remotePort = prop.getProperty("appium.port");
            remotePath = prop.getProperty("appium.path");
        } catch (IOException e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static PropertiesReader getPropertiesReader(){
        if (propertiesReader == null){
            propertiesReader = new PropertiesReader();
        }
        return propertiesReader;
    }


    public URL getUrl(){
        try {
            return new URL(String.format("http://%s:%s/%s",
                    remoteHost, remotePort, remotePath));
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
