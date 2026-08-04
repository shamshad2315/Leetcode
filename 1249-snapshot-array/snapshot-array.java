 import java.util.*;

class SnapshotArray {

    private int snapId;
    private List<int[]>[] history;

    public SnapshotArray(int length) {
        snapId = 0;
        history = new ArrayList[length];

        for (int i = 0; i < length; i++) {
            history[i] = new ArrayList<>();
            history[i].add(new int[]{0, 0}); // Initial value
        }
    }

    public void set(int index, int val) {
        List<int[]> list = history[index];

        // If current snapshot already has an entry, update it
        if (list.get(list.size() - 1)[0] == snapId) {
            list.get(list.size() - 1)[1] = val;
        } else {
            list.add(new int[]{snapId, val});
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> list = history[index];

        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid)[0] <= snap_id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return list.get(right)[1];
    }
}