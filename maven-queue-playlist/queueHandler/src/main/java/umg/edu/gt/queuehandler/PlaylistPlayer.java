package umg.edu.gt.queuehandler;

import umg.edu.gt.data_structure.queue.LinkedQueue;
import umg.edu.gt.data_structure.queue.Queue;

public class PlaylistPlayer {

    private final Queue<Song> highQueue = new LinkedQueue<>();
    private final Queue<Song> normalQueue = new LinkedQueue<>();

    // Extensiones (D)
    private int totalSongsPlayed = 0;
    private int totalSecondsPlayed = 0;

    public void addSong(Song song) {
        if (song.getPriority() == 1) highQueue.enqueue(song);
        else normalQueue.enqueue(song);
    }

    private boolean hasMore() {
        return !highQueue.isEmpty() || !normalQueue.isEmpty();
    }

    private Song nextSong() {
        if (!highQueue.isEmpty()) return highQueue.dequeue();
        return normalQueue.dequeue();
    }

    public void playAll() {
        System.out.println("[LOG] Starting playlist...");

        while (hasMore()) {
            Song s = nextSong();
            playSong(s);
        }

        System.out.println("[LOG] Playlist finished.");
        System.out.println("[LOG] Total songs played: " + totalSongsPlayed);
        System.out.println("[LOG] Total seconds played: " + totalSecondsPlayed);
    }

    private void playSong(Song s) {
        int dur = s.getDuration();

        System.out.println("[LOG] Now playing: " + s.getTitle() + " - " + s.getArtist() + " (" + dur + "s)");

        for (int sec = 1; sec <= dur; sec++) {
            String bar = progressBar(sec, dur, 10);
            System.out.println("[LOG] Playing: " + s.getTitle() + " | " + bar + " " + sec + "s / " + dur + "s");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) { }

            totalSecondsPlayed++;
        }

        totalSongsPlayed++;
        System.out.println("[LOG] Finished: " + s.getTitle());
    }

    private String progressBar(int current, int total, int width) {
        int filled = (int) Math.round((current * 1.0 / total) * width);
        if (filled < 0) filled = 0;
        if (filled > width) filled = width;

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < filled; i++) sb.append("#");
        for (int i = filled; i < width; i++) sb.append("-");
        sb.append("]");
        return sb.toString();
    }
}