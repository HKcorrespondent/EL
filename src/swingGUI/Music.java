package swingGUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

import javax.swing.JApplet;

public class Music {
	
	
		File file1;
		File file2;
		File file3;
		File file4;
		private boolean buttion=true;
		AudioClip  sound1,sound2,sound3,sound4,sound5;
		
		
			//构造方法
			public Music(){
			try {
				sound1 = JApplet.newAudioClip((getClass().getResource("bg_1.wav")));
				sound2 = Applet.newAudioClip(getClass().getResource("buttion.wav"));
				
				System.out.println(getClass().getResource("BGM.wav"));
//				sound3 = Applet.newAudioClip(getClass().getResource("fail.wav"));
//				sound4 = Applet.newAudioClip(getClass().getResource("reward.wav"));
//				sound5 = Applet.newAudioClip(getClass().getResource("buttion.wav"));
			} catch(OutOfMemoryError|Exception e){
				System.out.println("内存溢出");
				e.printStackTrace();
				}
			}	
		
			public void sound(String name){
				if(buttion){
						switch(name){
					case "BGM":
						System.out.println("!!!!!");
						
						sound1.loop();
						break;

					case "buttion":
						sound2.play();
						break;	
					}
				}
			}
			public void closeSound(){
				sound1.stop();
				buttion=false;
			}
			public void openSound(){
				sound1.loop();
				buttion=true;
			}

			public void start() {
				// TODO Auto-generated method stub
				sound1.play();
				
			}
	
	
	
	
}
