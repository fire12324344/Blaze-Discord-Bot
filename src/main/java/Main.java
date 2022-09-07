import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;


import javax.security.auth.login.LoginException;
import java.io.File;

public class Main extends ListenerAdapter {
    final String prefix = "!";
    public static void main(String[] args) throws LoginException {
        final String api = "MTAxNjg4NDM1ODA1NDkzNjY1Ng.G3kAxJ.S4S-_8-I0_xoBPBsXHlMZHoRG6LRRmjLpEhzGA";
        JDABuilder builder = JDABuilder.createDefault(api);
        builder.addEventListeners(new Main());
        builder.build();


    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
      switch (e.getMessage().getContentRaw()) {
          case "1352": e.getChannel().sendMessage("i hate people of coler").queue(); break;
          case prefix + "help":
              e.getChannel().sendMessage("No, fuck you").queue();
              break;
          case prefix + "blaze":
              e.getChannel().sendMessage("blaze").addFiles(FileUpload.fromData(new File("stuff/blaze.png"), "image.png")).queue();

      }

        }
    }

