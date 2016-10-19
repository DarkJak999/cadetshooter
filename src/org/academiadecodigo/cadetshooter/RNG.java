package org.academiadecodigo.cadetshooter;

/**
 * Created by codecadet on 18/10/16.
 */
public class RNG {

    public static int getRandom(int min, int max) {

        return (int) (Math.random() * (max - min) + min);
    }
}
