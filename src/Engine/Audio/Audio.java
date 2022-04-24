package Engine.Audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

/**
 * This class defines methods that implement audio functionality
 *
 * @author Blaise Nowosielski
 */
public class Audio extends Thread {

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

    /**
     * Gets the filePath attribute
     *
     * @return String filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the filePath attribute
     *
     * @param filePath a string defining the file path of the audio file to be played
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Gets the volume attribute
     *
     * @return double volume
     */
    public double getVolume() { return volume; }

    /**
     * Sets the volume attribute
     *
     * @param volume a double representing the loudness of the audio file being played
     */
    public void setVolume(double volume) {
        if (volume > 10 || volume < 0) {
            throw new IllegalArgumentException("Volume value has to be in range [0.0, 10.0].");
        }
        else {
            this.volume = volume;
            // maps volume range from between 0 & 10 to decibels (logarithmic)
            this.volControl.setValue((float) (6.0206 * Math.log10(this.volume)));
        }
    }

    /**
     * Gets the panAmount attribute
     *
     * @return float panAmount
     */
    public float getPanAmount() { return panAmount; }

    /**
     * Sets the panAmount attribute
     *
     * @param panAmount a float representing the left (-1) to right (1) stereo image of the audio file
     */
    public void setPanAmount(float panAmount) {
        if (panAmount > 1.0 || panAmount < -1.0 ) {
            throw new IllegalArgumentException("panAmount value has to be in range [-1.0, 1.0].");
        }
        else {
            this.panAmount = panAmount;
            this.panControl.setValue(panAmount);
        }
    }

    /**
     * Gets the mute attribute
     *
     * @return boolean mute
     */
    public boolean isMute() {
        return mute;
    }

    /**
     * Sets the mute attribute
     *
     * @param mute a boolean determining whether an audio file is muted or not
     */
    public void setMute(boolean mute) {
        this.mute = mute;
        this.muteControl.setValue(mute);
    }

    /**
     * Gets the isPlaying attribute
     *
     * @return boolean isPlaying
     */
    public boolean isPlaying() {
        return isPlaying;
    }

    /**
     * Gets the format by which the output line should be written
     *
     * @param lineInFormat the format details of the audio file being read by the input line
     * @return AudioFormat
     */
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

    /**
     * Opens the output line if not open
     * Reads every byte of data from the line reading the audio file and writes it to the output line
     * If it reaches the end of the audio file, closes the output line
     */
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
            // Closes output line
            lineOut.stop();
            isPlaying = false;
            lineOut.drain();
            lineOut.close();

        }
        catch ( IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * If the audio object is playing, stop it
     * If the audio object is not playing re-play the audio file from the beginning
     */
    public void replayPause() {
        if (isPlaying) {
            lineOut.stop();
            isPlaying = false;
            lineOut.drain();
            lineOut.close();
        }
        else {
            playAudio();
        }
    }

    /**
     * Connects the input line to the AudioSystem reading the file
     * Sets the format for writing to the output line and opens it
     * Gets the output line controls for volume, panning and muting and sets their values
     */
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
        this.volControl = (FloatControl) this.lineOut.getControl(FloatControl.Type.MASTER_GAIN);
        // maps volume range from decibels (logarithmic) to between 0 & 10
        this.volControl.setValue((float) this.volume);

        // CHANGES PAN
        // System.out.println(lineOut.isControlSupported(FloatControl.Type.PAN));
        this.panControl = (FloatControl) this.lineOut.getControl(FloatControl.Type.PAN);
        this.panControl.setValue(panAmount);

        // MUTE
        // System.out.println(lineOut.isControlSupported(BooleanControl.Type.MUTE));
        this.muteControl = (BooleanControl) this.lineOut.getControl(BooleanControl.Type.MUTE);
        this.muteControl.setValue(mute);
    }

    /**
     * The most primitive constructor, where the filePath is the only mandatory parameter
     * The other attributes are set to appropriate default values
     *
     * @param filePath a string defining the file path of the audio file to be played
     */
    public Audio(String filePath) {
        this.file = new File(filePath);
        setVolume(volume);
        this.panAmount = 0.0f;
        this.mute = false;
        this.buffSize = 4096;
        openLine();
    }

    /**
     * The most practical constructor, setting the filePath, volume, panAmount and mute
     *
     * @param filePath a string defining the file path of the audio file to be played
     * @param volume a double representing the loudness of the audio file being played
     * @param panAmount a float representing the left (-1) to right (1) stereo image of the audio file
     * @param mute a boolean determining whether an audio file is muted or not
     */
    public Audio(String filePath, double volume, float panAmount, boolean mute) {
        this.file = new File(filePath);
        setVolume(volume);
        this.panAmount = panAmount;
        this.mute = mute;
        openLine();
    }

    /**
     * The more specialist constructor, setting the filePath, volume, panAmount, mute and buffSize
     * Most users will not need to manipulate the buffer size
     * Only necessary if the default value is causing audio artifacts
     *
     * @param filePath a string defining the file path of the audio file to be played
     * @param volume a double representing the loudness of the audio file being played
     * @param panAmount a float representing the left (-1) to right (1) stereo image of the audio file
     * @param mute a boolean determining whether an audio file is muted or not
     * @param buffSize an int determining the size of the audio buffer
     */
    public Audio(String filePath, double volume, float panAmount, boolean mute, int buffSize) {
        this.file = new File(filePath);
        setVolume(volume);
        this.panAmount = panAmount;
        this.mute = mute;
        this.buffSize = buffSize;
        openLine();
    }

    /**
     * When the audio object started, it creates a new thread where run() is executed
     * This allows for audio to be played simultaneous to the rest of the game's execution
     * And for multiple audio files to be played at the same time
     */
    public void run() {
        playAudio();
    }
}
