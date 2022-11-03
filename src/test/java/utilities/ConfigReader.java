package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {

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
    public static String getProperty(String key) {

        return properties.getProperty(key);

    }
}


//    public static void main(String[] args) {
//        System.out.println(properties.getProperty("url_techproed"));
//        System.out.println(properties.getProperty("1111"));
//    }
//
//}
