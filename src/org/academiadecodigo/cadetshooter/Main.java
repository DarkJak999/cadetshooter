package org.academiadecodigo.cadetshooter;

/**
 * Created by codecadet on 18/10/16.
 */
public class Main {

    public static void main(String[] args) {

        Game g = new Game();

        g.init();
        try{
            //g.start();
            g.startMenu();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
