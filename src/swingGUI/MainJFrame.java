package swingGUI;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;




public class MainJFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//宽度
	public	static  int DEFAULT_WIDTH=600;
	//高度
	public	static  int DEFAULT_HEIGHT=800;
	
	static	Icon background = new ImageIcon(MainJFrame.class.getResource("background.png"));
	

	
	
	
	private EffPanel Effects = new EffPanel(DEFAULT_HEIGHT,DEFAULT_WIDTH);
	private GameJPanel game = new GameJPanel();
	private JPanel backgroundPanel = new JPanel();
	private StartPage starPage = new StartPage(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	private static Music music = new Music();
	
	
	CardLayout card = new CardLayout();

	
	JPanel pane=new JPanel();
	
	public MainJFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		setTitle("elimGame");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
//		
		backgroundPanel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	
		
		JLabel back= new JLabel(background);
		back.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	
				
		backgroundPanel.setLayout(null);
		backgroundPanel.add(Effects);
		backgroundPanel.add(game);
		backgroundPanel.add(back);
		
		 pane.setLayout(card);
	     pane.add(starPage, "starPage");
	     pane.add(backgroundPanel, "game");
	     
	     

	     
		add( pane);
		
		starPage.startGame.addActionListener(this);
	
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


		
		
	
//		JLayeredPane layeredPane=new JLayeredPane();
//		layeredPane.add(backgroundPanel, 0);
//		layeredPane.add(game, 2);
//		layeredPane.add(Effects,3);
//		layeredPane.add(starPage,1);
////		add(game);
//		
//		setLayeredPane(layeredPane);  
		
//		game.setVisible(false);
//		backgroundPanel.setVisible(false);
//		backgroundPanel.setVisible(true);
//		starPage.setVisible(true);
//		Effects.setVisible(false);
		music.sound("BGM");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource()==starPage.startGame)
	        {
//			 starPage.setVisible(false);
//			 game.setVisible(true);
//			 Effects.setVisible(true);
			 music.sound("buttion");
			 card.show(pane, "game");
			 
	            //这里还可以做些什么
	            
			 
			 
			 
			 
			 
	        }

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
			MainJFrame frame = new MainJFrame();

			frame.setVisible(true);
		}
		});
	}
	
	
	
	
	
}
