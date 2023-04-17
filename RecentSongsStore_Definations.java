package Code_Assignment_TestPackage.Runners.stepDefinations;

import Code_Assignment_TestPackage.Runners.stepActions.RecentSongsStore_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Properties;

public class RecentSongsStore_Definations {

    protected static Properties props = new Properties();
    static RecentSongsStore_Actions recentSongsStore_actions;

    @Given("Assume that the user has played 3 songs - S1, S2 and S3.")
    public static void RecentSongsStore() {
        recentSongsStore_actions.addSong(props.getProperty("user1"), props.getProperty("Song1"));
        recentSongsStore_actions.addSong("user2", "Song2");
        recentSongsStore_actions.addSong("user3", "Song3");
        System.out.println(recentSongsStore_actions.getRecentSongs("user3")); // [S3, S2, S1]

        recentSongsStore_actions.addSong("user2", "Song2");
        System.out.println(recentSongsStore_actions.getRecentSongs("user2")); // [S2, S4, S3]

        recentSongsStore_actions.addSong("user1", "Song1");
        System.out.println(recentSongsStore_actions.getRecentSongs("user1")); // [S1, S2, S4]
    }
}
