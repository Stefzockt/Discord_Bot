package org.stefzockt;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.util.Properties;

public class Builder{
    private final JDABuilder builder;
    public Builder(String[] args, Properties properties) {
        //Init the builder
        builder =  JDABuilder.createLight(properties.getProperty("token"));

        //Adds EventListener
        builder.addEventListeners(new MessageListener());

        //Enable bulk delete
        builder.setBulkDeleteSplittingEnabled(true);

        // Disable cache for member activities (streaming/games/spotify)
        builder.disableCache(CacheFlag.ACTIVITY);

        // Only cache members who are either in a voice channel or owner of the guild
        builder.setMemberCachePolicy(MemberCachePolicy.VOICE.or(MemberCachePolicy.OWNER));

        //Enables to view the Content and the Reactions to the Message
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_MESSAGES);

        // Disable presence updates and typing events
        builder.disableIntents(GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGE_TYPING);

        /*RichPresence Custom Activity (NOT SUPPORTED)
        builder.setActivity(Activity.of(Activity.ActivityType.CUSTOM_STATUS, "Test"));
         */
    }

    //TODO: Activity with custom Message
    public void setActivity(Activity.ActivityType activity, String name){
        builder.setActivity(Activity.of(activity, name));
    }

    public JDABuilder getBuilder() {
        return builder;
    }
}
