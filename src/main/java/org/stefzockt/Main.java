package org.stefzockt;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import java.util.Properties;



public class Main {
    public static void main(String[] args) {
        Properties prop = new Settings().load();
        //Bot
        try {
            JDA bot = JDABuilder.createDefault(prop.getProperty("token")).setActivity(Activity.watching("the master code")).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}