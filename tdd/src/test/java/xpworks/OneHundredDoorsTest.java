package xpworks;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class OneHundredDoorsTest {

    @Test
    public void oneDoorNoPass() {
        OneHundredDoors oneHundredDoors = new OneHundredDoors(1);

        boolean[] doorsState = oneHundredDoors.getDoorsState();

        assertArrayEquals(new boolean[]{false}, doorsState);
    }

    @Test
    public void oneDoorOnePass() {
        OneHundredDoors oneHundredDoors = new OneHundredDoors(1);
        oneHundredDoors.pass();

        boolean[] doorsState = oneHundredDoors.getDoorsState();

        assertArrayEquals(new boolean[]{true}, doorsState);
    }

    @Test
    public void twoDoorsNoPass() {
        OneHundredDoors oneHundredDoors = new OneHundredDoors(2);

        boolean[] doorsState = oneHundredDoors.getDoorsState();

        assertArrayEquals(new boolean[]{false, false}, doorsState);
    }

    @Test
    public void twoDoorsOnePass() {
        OneHundredDoors oneHundredDoors = new OneHundredDoors(2);
        oneHundredDoors.pass();

        boolean[] doorsState = oneHundredDoors.getDoorsState();

        assertArrayEquals(new boolean[]{true, true}, doorsState);
    }

    @Test
    public void twoDoorsTwoPasses() {
        OneHundredDoors oneHundredDoors = new OneHundredDoors(2);
        oneHundredDoors.pass();
        oneHundredDoors.pass();

        boolean[] doorsState = oneHundredDoors.getDoorsState();

        assertArrayEquals(new boolean[]{true, false}, doorsState);
    }

    @Test
    public void fourDoorsOnePass() {
        OneHundredDoors oneHundredDoors = new OneHundredDoors(4);
        oneHundredDoors.pass();

        boolean[] doorsState = oneHundredDoors.getDoorsState();

        assertArrayEquals(new boolean[]{true, true, true, true}, doorsState);
    }

    @Test
    public void fourDoorsTwoPasses() {
        OneHundredDoors oneHundredDoors = new OneHundredDoors(4);
        oneHundredDoors.pass();
        oneHundredDoors.pass();

        boolean[] doorsState = oneHundredDoors.getDoorsState();

        assertArrayEquals(new boolean[]{true, false, true, false}, doorsState);
    }

    @Test
    public void fourDoorsThreePasses() {
        OneHundredDoors oneHundredDoors = new OneHundredDoors(4);
        oneHundredDoors.pass();
        oneHundredDoors.pass();
        oneHundredDoors.pass();

        boolean[] doorsState = oneHundredDoors.getDoorsState();

        assertArrayEquals(new boolean[]{true, false, false, false}, doorsState);
    }

    @Test
    public void fourDoorsFourPasses() {
        OneHundredDoors oneHundredDoors = new OneHundredDoors(4);
        oneHundredDoors.pass();
        oneHundredDoors.pass();
        oneHundredDoors.pass();
        oneHundredDoors.pass();

        boolean[] doorsState = oneHundredDoors.getDoorsState();

        assertArrayEquals(new boolean[]{true, false, false, true}, doorsState);
    }
}
