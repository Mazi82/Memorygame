import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public class Sound {

    private AudioFormat format;
    private byte[] samples;

    public Sound(URL filename) {
        try {
            AudioInputStream stream
                    = AudioSystem.getAudioInputStream(filename);

            format = stream.getFormat();

            samples = getSamples(stream);
        } catch (UnsupportedAudioFileException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public byte[] getSamples() {
        return samples;
    }

    private byte[] getSamples(AudioInputStream audioStream) {
        int length = (int) (audioStream.getFrameLength()
                * format.getFrameSize());

        byte[] samples = new byte[length];
        DataInputStream is = new DataInputStream(audioStream);
        try {
            is.readFully(samples);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return samples;
    }

    public void play(InputStream source) {

        int bufferSize = format.getFrameSize()
                * Math.round(format.getSampleRate() / 10);
        byte[] buffer = new byte[bufferSize];
        SourceDataLine line;
        try {
            DataLine.Info info
                    = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format, bufferSize);
        } catch (LineUnavailableException ex) {
            System.out.println(ex);
            return;
        }

        line.start();

        try {
            int numBytesRead = 0;
            while (numBytesRead != -1) {
                numBytesRead
                        = source.read(buffer, 0, buffer.length);
                if (numBytesRead != -1) {
                    line.write(buffer, 0, numBytesRead);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        line.drain();

        line.close();

    }

}
