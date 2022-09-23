package design.memento;

/**
 * @author shuaishuai.wang
 * @date 2022-09-22
 **/
public class Snapshot {
    private String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
