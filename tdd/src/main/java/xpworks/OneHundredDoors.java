package xpworks;

public class OneHundredDoors {
    private int pass;
    private boolean[] doorsState;
    private int doorCount;

    public OneHundredDoors(int doorCount) {
        doorsState = new boolean[doorCount];
        this.doorCount = doorCount;
    }

    public boolean[] getDoorsState() {
        return doorsState;
    }

    public void pass() {
        pass++;
        changeDoorsState();
    }

    private void changeDoorsState() {
        for ( int doorIndex = pass - 1; doorIndex <= doorCount - 1; doorIndex += pass ) {
            doorsState[doorIndex] = !doorsState[doorIndex];
        }
    }
}
