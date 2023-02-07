import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.*;

public class DevBadge extends ListenerAdapter {
    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (event.getName().equals("devbadge")) {
            event.deferReply().queue();
            event.getHook().sendMessage("Fuck off scriptkiddie").queue();
        }
    }
}
