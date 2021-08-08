package CyDarkCat.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;
import java.awt.*;
import java.util.ArrayList;

public class EventsJDA extends ListenerAdapter{
    ArrayList<String> cola = new ArrayList<String>();
    private Guild guild;
    private String Player;
    public String getPlayer(){
        return this.Player;
    }
    public void setPlayer(){
        String Player = this.Player;
    }

        @Override
    public void onGuildMessageReceived(@Nonnull  GuildMessageReceivedEvent event) {


        super.onGuildMessageReceived(event);

        User user = event.getAuthor();

        if (user.isBot() || event.isWebhookMessage()) {
            return;
        }

        String[] raw = event.getMessage().getContentRaw().split(" ");
        String prefix = "!";

        if(raw[0].equalsIgnoreCase(prefix + "gato") && user.getId().equals("208711432303280139")) {

        } else if(raw[0].equalsIgnoreCase(prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Bot Information");
            info.setDescription("Put some info about the bot here");
            info.addField("Creator", "Blake", false);
            info.setColor(0xffffff);

            event.getChannel().sendMessage(info.build()).queue();
        }else if(raw[0].equalsIgnoreCase(prefix + "scrim")){
            String userId = event.getAuthor().getId();
            cola.add(userId);
            for(int i = 0;i<cola.size();i++){
                if(cola.get(i).equalsIgnoreCase(event.getAuthor().getId())){
                    EmbedBuilder info = new EmbedBuilder();
                    info.setTitle("HawksEvents");
                    info.setDescription("No puedes Volver a Solicitar un Servidor");
                    info.setColor(Color.RED);
                //    Role verifiedrole = guild.getRolesByName("Verified",false).get(0);
                    event.getChannel().sendMessage(info.build()).queue();
                    cola.remove(userId);
                    break;
                }

            }

            if(cola.size() == 3 ){
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("HawksEvents");
                info.setDescription("Servidores Llenos");
                info.setColor(Color.RED);
            //    Role verifiedrole = guild.getRolesByName("Verified",false).get(0);
                event.getChannel().sendMessage(info.build()).queue();
                return;
            }else{
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("HawksEvents");
                info.setDescription("Solicitando Servidores");
                info.setColor(Color.CYAN);
                Role verifiedrole = guild.getRolesByName("Verified",false).get(0);
                event.getChannel().sendMessage(info.build()).queue();

            }
          //  EmbedBuilder info = new EmbedBuilder();
            //info.setTitle("HawksEvents");
            //info.setDescription("Solicitando un servidor...");
            //info.setColor(Color.CYAN);
           // event.getChannel().sendMessage(info.build()).queue();
           // Role verifiedrole = guild.getRolesByName("Verified",false).get(0);
           // event.getChannel().sendMessage(verifiedrole.getAsMention()).queue();
           // guild.createVoiceChannel("Team A").queue();
           // guild.createVoiceChannel("Team B").queue();
            

        }else if(raw[0].equalsIgnoreCase(prefix + "Player")){
            if(raw.length != 2){
                EmbedBuilder info = new EmbedBuilder();
                info.setTitle("HawksEvents");
                info.setDescription("Introduce el Nombre del Jugador");
                info.setColor(Color.RED);
                event.getChannel().sendMessage(info.build()).queue();
            }
        }






    }
}
