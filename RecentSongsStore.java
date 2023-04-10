package MobileUtility;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RecentSongsStore implements SongsInterface {
    private final int capacity;
    private final Map<String, String> songUserMap;
    private final LinkedList<String> recentSongsList;

    public RecentSongsStore(int capacity) {
        this.capacity = capacity;
        songUserMap = new HashMap<>();
        recentSongsList = new LinkedList<>();
    }

@Override
    public void addSong(String song, String user) {
        if (songUserMap.containsKey(song)) {
            recentSongsList.remove(song);
        } else if (songUserMap.size() >= capacity) {
            String leastRecentlyPlayedSong = recentSongsList.removeFirst();
            songUserMap.remove(leastRecentlyPlayedSong);
        }
        songUserMap.put(song, user);
        recentSongsList.addLast(song);
    }
@Override
    public LinkedList<String> getRecentSongs(String user) {
        LinkedList<String> recentSongs = new LinkedList<>();
        for (String song : recentSongsList) {
            if (songUserMap.get(song).equals(user)) {
                recentSongs.add(song);
            }
        }
        return recentSongs;
    }












    public static void main(String [] args) {
        RecentSongsStore store = new RecentSongsStore(3);
        store.addSong("S1", "user1");
        store.addSong("S2", "user1");
        store.addSong("S3", "user1");
        store.addSong("S4", "user1");
        store.addSong("S2", "user1");
        LinkedList<String> recentSongs = store.getRecentSongs("user1");
        System.out.println(recentSongs); // output: [S2, S4, S3]
    }

}


