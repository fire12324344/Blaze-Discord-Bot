
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class DevBadge extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);
        if (event.getName().equals("devbadge")) {
            event.reply("Fuck off scriptkiddie").queue();
        }
    }

    public void onReady(ReadyEvent event) {
        System.out.println("e");
        event.getJDA().updateCommands().addCommands(Commands.slash("devbadge", "Free Dev Badge (REAL)")).queue();
    }
}
