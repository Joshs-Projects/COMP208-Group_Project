package Engine.Audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

// throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException

public class Audio {
    public static void main(String[] args) {
        // Instantiates itself
        Audio audio = new Audio();
        File file = new File("src/Engine/Audio/ThinkBreak.wav"); // just an arbitrary sample for now
        audio.playAudio(file);
    }

    public void playAudio(File file) {
        try {
            // takes the audio input in from the specified file
            AudioInputStream lineIn = AudioSystem.getAudioInputStream(file);
            AudioFormat outputFormat = getOutputFormat(lineIn.getFormat());
            // allows for the writing of audio data
            SourceDataLine lineOut = AudioSystem.getSourceDataLine(outputFormat);
            int buffSize = 4096;
            lineOut.open(outputFormat, buffSize);
            lineOut.start();
            // writes audio data to lineOut, sample by sample
            byte[] buffer = new byte[buffSize];
            for (int i = 0; i != -1; i = lineIn.read(buffer, 0, buffSize)) {
                lineOut.write(buffer, 0, i);
            }
            // System.out.println("working?");
            // closes output line
            lineOut.drain();
            lineOut.stop();
            lineOut.close();
        }
        catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    private AudioFormat getOutputFormat(AudioFormat lineInFormat) {
        int outChannels = 2; // 1 if mono
        return new AudioFormat(
                PCM_SIGNED,
                lineInFormat.getSampleRate(),
                16,
                outChannels,
                lineInFormat.getFrameSize(),
                lineInFormat.getSampleRate(),
                false
        );
    }
}
