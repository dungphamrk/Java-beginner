package Ex4;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();

        player.play("mp4", "movie.mp4");
        player.play("vlc", "song.vlc");
        player.play("mp3", "audio.mp3"); // Định dạng không được hỗ trợ

    }
}