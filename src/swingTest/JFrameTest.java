package swingTest;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;




public class JFrameTest extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//宽度
	public	static  int DEFAULT_WIDTH=600;
	//高度
	public	static  int DEFAULT_HEIGHT=800;
	
	static	Icon background = new ImageIcon(JFrameTest.class.getResource("background.png"));
	
	
	JLayeredPane layeredPane;
	public JFrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		setResizable(false);
		setTitle("elimGame");
		
		//设定整个界面的宽度和高度
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		JLayeredPane layeredPane=new JLayeredPane();

		GameJPanel game = new GameJPanel();
		JPanel backgroundPanel = new JPanel();
		System.out.println(JFrameTest.class.getResource("background.png"));
		backgroundPanel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		
		System.out.println(background.getIconWidth() + " "+ background.getIconHeight());
		
		backgroundPanel.add(new JLabel(background));
		
		backgroundPanel.setVisible(true);
		
		
		layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(game, JLayeredPane.PALETTE_LAYER);
		
//		add(game);
		
		setLayeredPane(layeredPane);  
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		gameStart();
		
		
		
	}
	static public void gameStart(){
		EventQueue.invokeLater(new Runnable()
		{
		public void run()
		{
			JFrameTest frame = new JFrameTest();

			frame.setVisible(true);
		}
		});
	}
	
	
	
}
