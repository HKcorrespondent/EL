package swingTest;

import java.awt.EventQueue;

import javax.swing.JFrame;




public class JFrameTest extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//���
	public	static  int DEFAULT_WIDTH=600;
	//�߶�
	public	static  int DEFAULT_HEIGHT=800;
	
	public JFrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		setTitle("elimGame");
		
		//�趨��������Ŀ�Ⱥ͸߶�
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		

		add(new GameJPanel());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
