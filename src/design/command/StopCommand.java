package design.command;

/**
 * @author shuaishuai.wang
 * @date 2022-09-23
 **/
public class StopCommand implements Command{

    private AudioPlayer audioPlayer;

    public StopCommand(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void execute() {
        audioPlayer.stop();
    }
}
