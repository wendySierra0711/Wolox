package com.nanofy.apis.util;

import com.nanofy.apis.model.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Credentials {

    public static List<Login> credentidals(String rolName){
        Properties properties = new Properties();
        Login login = new Login();
        List<Login> data = new ArrayList<>();
        try {
            properties.load(new FileInputStream(new File("env/credentials.properties")));
            switch (rolName)
            {
                case "administrator":
                {
                    login.setEmail(properties.getProperty("User_Admin"));
                    login.setPassword(properties.getProperty("Pass_Admin"));
                    break;
                }
                case "regular":
                {
                    login.setEmail(properties.getProperty("User_Regular"));
                    login.setPassword(properties.getProperty("Pass_Regular"));
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        data.add(login);
        return  data;
    }
    public static String environment(String nameEnv) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("env/credentials.properties")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(nameEnv);
    }
}
