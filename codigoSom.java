
// Java program to play an Audio 
// file using Clip Object 
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
  
public class SimpleAudioPlayer  
{ 
  
    // to store current position 
    Long currentFrame; 
    Clip clip; 
      
    // current status of clip 
    String status; 
      
    AudioInputStream audioInputStream; 
    static String filePath; 
  
    // constructor to initialize streams and clip 
    public SimpleAudioPlayer() 
        throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException  
    { 
        // create AudioInputStream object 
        audioInputStream =  
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); 
          
        // create clip reference 
        clip = AudioSystem.getClip(); 
          
        // open audioInputStream to the clip 
        clip.open(audioInputStream); 
          
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
  
    public static void main(String[] args)  
    { 
        try
        { 
            filePath = "Your path for the file"; 
            SimpleAudioPlayer audioPlayer =  
                            new SimpleAudioPlayer(); 
              
            audioPlayer.play(); 
            Scanner sc = new Scanner(System.in); 
              
            while (true) 
            { 
                System.out.println("1. pause"); 
                System.out.println("2. resume"); 
                System.out.println("3. restart"); 
                System.out.println("4. stop"); 
                System.out.println("5. Jump to specific time"); 
                int c = sc.nextInt(); 
                audioPlayer.gotoChoice(c); 
                if (c == 4) 
                break; 
            } 
            sc.close(); 
        }  
          
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace(); 
          
          } 
    } 
      
    // Work as the user enters his choice 
      
    private void gotoChoice(int c) 
            throws IOException, LineUnavailableException, UnsupportedAudioFileException  
    { 
        switch (c)  
        { 
            case 1: 
                pause(); 
                break; 
            case 2: 
                resumeAudio(); 
                break; 
            case 3: 
                restart(); 
                break; 
            case 4: 
                stop(); 
                break; 
            case 5: 
                System.out.println("Enter time (" + 0 +  
                ", " + clip.getMicrosecondLength() + ")"); 
                Scanner sc = new Scanner(System.in); 
                long c1 = sc.nextLong(); 
                jump(c1); 
                break; 
      
        } 
      
    } 
      
    // Method to play the audio 
    public void play()  
    { 
        //start the clip 
        clip.start(); 
          
        status = "play"; 
    } 
      
    // Method to pause the audio 
    public void pause()  
    { 
        if (status.equals("paused"))  
        { 
            System.out.println("audio is already paused"); 
            return; 
        } 
        this.currentFrame =  
        this.clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 
      
    // Method to resume the audio 
    public void resumeAudio() throws UnsupportedAudioFileException, 
                                IOException, LineUnavailableException  
    { 
        if (status.equals("play"))  
        { 
            System.out.println("Audio is already "+ 
            "being played"); 
            return; 
        } 
        clip.close(); 
        resetAudioStream(); 
        clip.setMicrosecondPosition(currentFrame); 
        this.play(); 
    } 
      
    // Method to restart the audio 
    public void restart() throws IOException, LineUnavailableException, 
                                            UnsupportedAudioFileException  
    { 
        clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        currentFrame = 0L; 
        clip.setMicrosecondPosition(0); 
        this.play(); 
    } 
      
    // Method to stop the audio 
    public void stop() throws UnsupportedAudioFileException, 
    IOException, LineUnavailableException  
    { 
        currentFrame = 0L; 
        clip.stop(); 
        clip.close(); 
    } 
      
    // Method to jump over a specific part 
    public void jump(long c) throws UnsupportedAudioFileException, IOException, 
                                                        LineUnavailableException  
    { 
        if (c > 0 && c < clip.getMicrosecondLength())  
        { 
            clip.stop(); 
            clip.close(); 
            resetAudioStream(); 
            currentFrame = c; 
            clip.setMicrosecondPosition(c); 
            this.play(); 
        } 
    } 
      
    // Method to reset audio stream 
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, 
                                            LineUnavailableException  
    { 
        audioInputStream = AudioSystem.getAudioInputStream( 
        new File(filePath).getAbsoluteFile()); 
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
  
} 



//*-------- Other example 



import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Music {

    private File track;
    private SourceDataLine line;
    private AudioInputStream din;
    private AudioFormat decodeFormat;
    public Music()
    {
        this.track = null;
        this.line = null;
        this.din = null;
    }

    public Music(File music)
    {
        try
        {
            //abre arquivo de audio
            this.track = music;
            //cria um strem de entrada do arquivo
            AudioInputStream ais = AudioSystem.getAudioInputStream(this.track);
            //seleciona o formato do arquivo de audio
            AudioFormat baseFormat = ais.getFormat();
            //configura a decodificação
            decodeFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED, // Encoding to use
                baseFormat.getSampleRate(),	  // sample rate (same as base format)
                16,				  // sample size in bits (thx to Javazoom)
                baseFormat.getChannels(),	  // # of Channels
                baseFormat.getChannels()*2,	  // Frame Size
                baseFormat.getSampleRate(),	  // Frame Rate
                false				  // Big Endian
            );

            din = AudioSystem.getAudioInputStream(decodeFormat, ais);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, getDecodeFormat());
	    this.line = (SourceDataLine) AudioSystem.getLine(info);
        }
        catch(Exception e){}
    }
...geters e seters.




import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Play implements Runnable {

    private boolean waiting = false;
    private SourceDataLine line;
    private AudioInputStream din;
    private AudioFormat decodeFormat;

    public Play (Music track)
    {
        this.line = track.getLine();
        this.din = track.getDin();
        this.decodeFormat = track.getDecodeFormat();

    }

    //metodo para pausar a thread.. a propria thread deve se parar, e não uma thread externa
    public synchronized void aguardar() {
        waiting = true;
    }

    //metodo para reiniciar uma thread
    public void continuar() {
        waiting = false;
        synchronized(this) {
            this.notify();
        }
    }
    
     //aqui executa a musica
    public void run() {
        try
        {
            if(line != null)
            {
		line.open(decodeFormat);
		byte[] data = new byte[4096];
		// Start
		line.start();
        	int nBytesRead;
               //toca enquanto a musica não acaba
		while ((nBytesRead = din.read(data, 0, data.length)) != -1)
                {
                    //se for solicitado para para  a propria thread para
                    while (waiting) {
                        synchronized (this) {
                            wait(); //Note que essa thread mesmo chama o wait
                        }
                    }
                    line.write(data, 0, nBytesRead);
		}
		// Stop
		line.drain();
		line.stop();
		line.close();
		din.close();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        }
    }
}


Music track = new Music("/home/lucas/Music/eric clapton-layla.mp3"); //no windows seria C:\\diretório em que a musica se encontra\\eric clapton-layla.mp3
Play play = new Play(track);
Thread newThrd = new Thread(play);
newThrd.start();

