package umg.edu.gt.queuehandler;

public class Main {
    public static void main(String[] args) {
        PlaylistPlayer player = new PlaylistPlayer();

 
        player.addSong(new Song("Pretty Savage", "Blackpink", 12, 1));
        player.addSong(new Song("People=Shit", "Slipknot", 8, 2));
        player.addSong(new Song("Like Jennie", "JENNIE", 15, 1));
        player.addSong(new Song("Feel Good Inc.", "Gorillaz", 10, 2));
        player.addSong(new Song("Snuff", "Slipknot", 6, 2));

        player.playAll();
    }
}