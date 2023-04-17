package Coding_Assignment_Package;


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
    public List<String> getRecentSongs(String user) {
        if (!songUserMap.containsKey(user)) {
            return new ArrayList<String>();
        }
        return new ArrayList<String>(songUserMap.get(user));
    }




}


