package org.stefzockt;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.util.Properties;

public class MessageListener extends ListenerAdapter
{
    public static void main(String[] args) {
        //Load the Settings-file into the Properties Obj
        Properties prop = new Settings().load();

        //Build the Bot with the Builder and
        JDABuilder bot = new Builder(args,prop).getBuilder();

        //Bot
        try {
            bot.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
        }
        else
        {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());

            if (event.getMessage().getContentRaw().equals("!ping")){
            }
        }
    }
}