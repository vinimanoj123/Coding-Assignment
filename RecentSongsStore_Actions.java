package Code_Assignment_TestPackage.Runners.stepActions;

import Coding_Assignment_Package.RecentSongsStore;
import Coding_Assignment_Package.SongsInterface;

import java.util.*;


public class RecentSongsStore_Actions implements SongsInterface {

    protected static Properties props = new Properties();

    public void addSong(String user, String song) {
        RecentSongsStore recentSongsStore= new  RecentSongsStore(Integer.parseInt(props.getProperty("capacity")));
        recentSongsStore.addSong(user , song);
        recentSongsStore.getRecentSongs(user);
    }
@Override
    public List<String> getRecentSongs(String user) {
    RecentSongsStore recentSongsStore= new  RecentSongsStore(Integer.parseInt(props.getProperty("capacity")));
    recentSongsStore.getRecentSongs(user);
    return getRecentSongs(user);
}

}
