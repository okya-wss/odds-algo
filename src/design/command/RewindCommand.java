package design.command;

/**
 * @author shuaishuai.wang
 * @date 2022-09-23
 **/
public class RewindCommand implements Command{
    private AudioPlayer audioPlayer;

    public RewindCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        audioPlayer.rewind();
    }
}
