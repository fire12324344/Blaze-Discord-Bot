import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.UnicodeEmoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.FileUpload;

import javax.imageio.ImageIO;
import javax.security.auth.login.LoginException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.regex.Pattern;

public class Main extends ListenerAdapter {
    final String prefix = "!";
    public static void main(String[] args) throws LoginException {
        BufferedReader reader;
        String api;
        Message.suppressContentIntentWarning();
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/api.txt"));
            api = reader.readLine();
        } catch (FileNotFoundException e) {
            reader=null;
            api=null;
        } catch (IOException e) {
            api=null;
        }

        JDABuilder builder = JDABuilder.createDefault(api);
        builder.addEventListeners(new Main());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (Pattern.matches("[u,o] *w *[u,o]", e.getMessage().getContentRaw())) {
            System.out.println("match");
            e.getChannel().sendMessage("NO FURRIES").queue();
        }
        switch (e.getMessage().getContentRaw()) {
          case "1352":
              e.getChannel().sendMessage("i hate people of coler").queue();
              break; //api
          case prefix + "help":
              e.getChannel().sendMessage("No, fuck you").queue();
              break;
          case prefix + "blaze":
              e.getChannel().sendMessage("blaze").addFiles(FileUpload.fromData(new File("stuff/blaze.png"), "image.png")).queue();
              break;
          case prefix + "blazesex":
              e.getMessage().addReaction(Emoji.fromUnicode("U+1F928")).queue();
              e.getChannel().sendMessage("i'm 16").queue();
          case prefix + "blazehat":
              BlazeHatter blazehat = new BlazeHatter();
              try {
                  e.getMessage().getAttachments().get(0).downloadToFile(new File("src/main/resources/input.png"));
              } catch (IndexOutOfBoundsException noImage) {
                  break;
              }
              int[] tem = new int[2];
              try {
                  Thread.sleep(400);
                  tem = blazehat.run();
                  Thread.sleep(400);
              } catch (InterruptedException | IOException interruptedException) {
                  interruptedException.printStackTrace();
                  blazehat.undo();
              }

              Container pane = blazehat.getContentPane();
              pane.setSize(tem[0], tem[1]);
              BufferedImage im = new BufferedImage(pane.getWidth(), pane.getHeight(), BufferedImage.TYPE_INT_ARGB);
              pane.paint(im.getGraphics());
              try {
                  ImageIO.write(im, "PNG", new File("src/main/resources/output.png"));
              } catch (IOException ioException) {
                  ioException.printStackTrace();
              }
              e.getChannel().sendMessage("").addFiles(FileUpload.fromData(new File("src/main/resources/output.png"), "blazed.png")).queue();
              blazehat.undo();
              break;
      }

        }
    }

