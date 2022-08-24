package org.stefzockt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Settings {
    protected Properties prop = new Properties();
    protected String fileName = "bot.config";

    public Properties load(){
        //Read Config
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

}
