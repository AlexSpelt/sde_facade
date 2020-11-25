package app.cinema.facade;

import app.cinema.devices.*;

public class HomeCinema {

    private Amplifier amp = new Amplifier("Top-O-Line Amplifier");
    private Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);

    private DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
    private CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);

    private Projector projector = new Projector("Top-O-Line Projector", dvd);
    private TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
    private Screen screen = new Screen("Theater Screen");
    private PopcornPopper popper = new PopcornPopper("Popcorn Popper");

    // this variable will keep track of what the cinema is playing.
    private MediumTypes playing = null;

    public void playMovie(String movie) {
        this.playing = MediumTypes.movie;

        popper.on();
        popper.pop();

        lights.dim(20);
        screen.down();

        projector.on();
        projector.wideScreenMode();

        amp.on();
        amp.setDvd(dvd);
        amp.setVolume(5);

        dvd.on();
        dvd.setSurroundAudio();
        dvd.play(movie);
    }

    public void playMusic(String title) {
        this.playing = MediumTypes.music;

        lights.on();
        amp.on();
        amp.setVolume(5);
        amp.setCd(cd);
        amp.setStereoSound();
        cd.on();
        cd.play(title);
    }

    public void playRadio(double frequency) {
        this.playing = MediumTypes.radio;

        tuner.on();
        tuner.setFrequency(frequency);
        amp.on();
        amp.setVolume(5);
        amp.setTuner(tuner);
    }

    public void stop() {
        switch (this.playing) {
            case movie:

                popper.off();
                lights.on();
                screen.up();
                projector.off();
                amp.off();
                dvd.stop();
                dvd.eject();
                dvd.off();

                break;
            case music:

                amp.off();
                amp.setCd(cd);
                cd.eject();
                cd.off();

                break;
            case radio:

                tuner.off();
                amp.off();

                break;
        }

        this.playing = null;
    }

}
