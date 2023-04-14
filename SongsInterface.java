package MobileUtility;

import java.util.LinkedList;
import java.util.List;

public interface SongsInterface {

    public abstract void addSong(String song, String user);

    public abstract List<String> getRecentSongs(String user);
}
