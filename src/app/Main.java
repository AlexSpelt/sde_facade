package app;

import app.cinema.facade.HomeCinema;

public class Main {

    public static void main(String[] args) {

        HomeCinema homeCinema = new HomeCinema();

        homeCinema.playMovie("Lord of the rings");
        homeCinema.stop();

        homeCinema.playMusic("Raver's Fantasy - Firelite");
        homeCinema.stop();

        homeCinema.playRadio(88.4d);
        homeCinema.stop();

    }
}
