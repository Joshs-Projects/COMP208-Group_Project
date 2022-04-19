import Engine.Audio.Audio;

public class AudioTester {
    public static void main(String[] args) throws InterruptedException {
        // Instantiates itself
        Audio audio = new Audio("src/Engine/Audio/ThinkBreak.wav");
        Audio audio2 = new Audio("src/Engine/Audio/ThinkBreak.wav");
        //File file = new File("src/Engine/Audio/ThinkBreak.wav"); // just an arbitrary sample for now
        //audio.playAudio();
        audio.start();
        Thread.sleep(1000);
        audio.playPause();
        Thread.sleep(500);
        audio.playPause();
        System.out.println("dududu");
        /*
        audio.playPause();
        System.out.println("Playing again");
        audio.playAudio();
        */

    }
}
