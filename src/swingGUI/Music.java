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
		private static boolean buttion=true;
		static AudioClip  sound1,sound2,sound3,sound4,sound5;
		
		
			//���췽��
			public Music(){
			try {
				sound1 = JApplet.newAudioClip((getClass().getResource("bg_1.wav")));
				sound2 = Applet.newAudioClip(getClass().getResource("buttion.wav"));
				sound3 = Applet.newAudioClip(getClass().getResource("a6.wav"));
				sound4 = Applet.newAudioClip(getClass().getResource("����1.wav"));
//				sound5 = Applet.newAudioClip(getClass().getResource("buttion.wav"));
			} catch(OutOfMemoryError|Exception e){
				System.out.println("�ڴ����");
				e.printStackTrace();
				}
			}	
		
			public static void sound(String name){
				if(buttion){
						switch(name){
					case "BGM":
					
						sound1.loop();
						break;

					case "buttion":
						sound2.play();
						break;	
					case "a6":
						sound3.play();
						break;	
					case "����1":
						sound4.play();
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
