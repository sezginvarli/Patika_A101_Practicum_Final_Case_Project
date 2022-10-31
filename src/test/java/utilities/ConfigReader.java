package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Create Properties object
    private static Properties properties;

    //Create a static block to run First
    static {
        //Path of properties file
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key){

        return properties.getProperty(key);

    }

    public static void main(String[] args) {
        System.out.println(properties.getProperty("url_techproed"));
        System.out.println(properties.getProperty("1111"));
    }


}
