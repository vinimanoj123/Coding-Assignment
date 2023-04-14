package MobileUtility;


import java.util.*;

public class RecentSongsStore implements SongsInterface {
    private final int capacity;
    private Map<String, LinkedList<String>> songUserMap;

    public RecentSongsStore(int capacity) {
        this.capacity = capacity;
        songUserMap = new HashMap<>();
    }

@Override
    public void addSong(String user, String song) {
    if (!songUserMap.containsKey(user)) {
        songUserMap.put(user, new LinkedList<String>());
    }
    LinkedList<String> songsList = songUserMap.get(user);
    if (songsList.contains(song)) {
        songsList.remove(song);
    }
    else if (songsList.size() == capacity) {
        songsList.removeLast();
    }
    songsList.addFirst(song);
}
@Override
public List<String> getRecentSongs(String user) {
    if (!songUserMap.containsKey(user)) {
        return new ArrayList<String>();
    }
    return new ArrayList<String>(songUserMap.get(user));
}


    public static void main(String [] args) {
        RecentSongsStore store = new RecentSongsStore(3);
        store.addSong("user1", "S1");
        store.addSong("user2", "S2");
        store.addSong("user3", "S3");
        System.out.println(store.getRecentSongs("user3")); // [S3, S2, S1]

        store.addSong("user2", "S2");
        System.out.println(store.getRecentSongs("user2")); // [S2, S4, S3]

        store.addSong("user1", "S1");
        System.out.println(store.getRecentSongs("user1")); // [S1, S2, S4]
    }

}


