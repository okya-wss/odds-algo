package design.memento;

import java.util.Stack;

/**
 * @author shuaishuai.wang
 * @date 2022-09-22
 **/
public class SnapshotHolder {

    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }
}
