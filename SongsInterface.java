package MobileUtility;

import java.util.LinkedList;

public interface SongsInterface {

    public abstract void addSong(String song, String user);

    public abstract LinkedList<String> getRecentSongs(String user);
}
