package com.mycompany.employeeproject.util;

import com.mycompany.employeeproject.Constant;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static String getProperty(String propertyName){
        Properties prop = new Properties();

        try(InputStream fis = new FileInputStream(Constant.PROP_PATH)){
            prop.load(fis);
            String result = prop.getProperty(propertyName);
            return result;
        }catch (IOException e){
            return null;
        }
    }
}
