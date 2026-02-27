package umg.edu.gt.queuehandler;

public class Song {
private final String title;
private final String artist;
private final int duration;
private final int priority;

public Song(String title, String artist, int duration, int priority) {
	if (duration < 5 || duration > 30) throw new IllegalArgumentException("Duration must be 5..30");
	if (priority !=1 && priority !=2)throw new IllegalArgumentException("Priority must be 1 or 2");
	this.title = title;
	this.artist = artist;
	this.duration = duration;
	this.priority = priority;
}
public String getTitle() {return title;}
public String getArtist() {return artist;}
public int getDuration() {return duration;}
public int getPriority() {return priority;}


}
