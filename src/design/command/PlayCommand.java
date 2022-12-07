package design.command;

/**
 * @author shuaishuai.wang
 * @date 2022-09-23
 **/
public class PlayCommand implements Command{

    private AudioPlayer audioPlayer;

    public PlayCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        audioPlayer.play();
    }
}
