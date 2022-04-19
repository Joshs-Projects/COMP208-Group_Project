package Engine.Audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

public class Audio extends Thread {

    //Add private attributes for
    private String filePath;
    private File file;
    private double volume;
    private float panAmount;
    private boolean mute;
    private boolean isPlaying;
    private int buffSize = 4096;

    private AudioInputStream lineIn;
    private SourceDataLine lineOut;
    private FloatControl volControl;
    private FloatControl panControl;
    private BooleanControl muteControl;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public double getVolume() {
        if (volume > 10 || volume < 0) {
            throw new IllegalArgumentException("Volume value has to be in range [0.0, 10.0].");
        }
        else {
            return volume;
        }
    }

    public void setVolume(double volume) {
        this.volume = volume;
        this.volControl.setValue((float) (6.0206 * Math.log10(this.volume)));
    }

    public float getPanAmount() {
        if (panAmount > 1.0 || panAmount < -1.0 ) {
            throw new IllegalArgumentException("panAmount value has to be in range [-1.0, 1.0].");
        } else {
            return panAmount;
        }
    }

    public void setPanAmount(float panAmount) {
        this.panAmount = panAmount;
        this.panControl.setValue(panAmount);
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
        this.muteControl.setValue(mute);
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void playAudio() {
        if (!lineOut.isOpen()) {
            openLine();
        }
        try {
            lineOut.start();
            isPlaying = true;

            byte[] buffer = new byte[this.buffSize];
            for (int i = 0; i != -1; i = lineIn.read(buffer, 0, buffSize)) {
                lineOut.write(buffer, 0, i);
            }
            // System.out.println("working?");
            // closes output line
            lineOut.drain();
            lineOut.stop();
            isPlaying = false;
            lineOut.close();
        }
        catch ( IOException e) {
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

    public void playPause() {
        if (isPlaying) {
            lineOut.stop();
            System.out.println("stopped");
        }
        else {
            lineOut.start();
            System.out.println("started");
        }
    }

    private void openLine(){
        try {
            this.lineIn = AudioSystem.getAudioInputStream(file);
            AudioFormat outputFormat = getOutputFormat(lineIn.getFormat());
            this.lineOut = AudioSystem.getSourceDataLine(outputFormat);
            this.lineOut.open(outputFormat, this.buffSize);
        }
        catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        // CHANGES VOLUME
        // System.out.println(lineOut.isControlSupported(FloatControl.Type.MASTER_GAIN));
        // maps volume range from decibels (logarithmic) to between 0 and 10
        this.volControl = (FloatControl) this.lineOut.getControl(FloatControl.Type.MASTER_GAIN);
        this.volControl.setValue((float) (6.0206 * Math.log10(this.volume)));

        // CHANGES PAN
        // System.out.println(lineOut.isControlSupported(FloatControl.Type.PAN));
        this.panControl = (FloatControl) this.lineOut.getControl(FloatControl.Type.PAN);
        this.panControl.setValue(panAmount);

        // MUTE
        // System.out.println(lineOut.isControlSupported(BooleanControl.Type.MUTE));
        this.muteControl = (BooleanControl) this.lineOut.getControl(BooleanControl.Type.MUTE);
        this.muteControl.setValue(mute);
    }

    //Default constructor
    public Audio(String filePath) {
        this.file = new File(filePath);
        this.volume = 2.0;
        this.panAmount = 0.0f;
        this.mute = false;
        this.buffSize = 4096;
        openLine();
    }

    public Audio(String filePath, double volume, float panAmount, boolean mute) {
        this.file = new File(filePath);
        this.volume = volume;
        this.panAmount = panAmount;
        this.mute = mute;
        openLine();
    }

    public Audio(String filePath, double volume, float panAmount, boolean mute, int buffSize) {
        this.file = new File(filePath);
        this.volume = volume;
        this.panAmount = panAmount;
        this.mute = mute;
        this.buffSize = buffSize;
        openLine();
    }

    public void run() {
        playAudio();
    }
}
