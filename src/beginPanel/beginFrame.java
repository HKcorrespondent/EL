package beginPanel;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swingTest.JFrameTest;

public class beginFrame {
	static	Icon gif = new ImageIcon(beginFrame.class.getResource("commonGem.gif"));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		EventQueue.invokeLater(new Runnable()
//		{
//		public void run()
//		{
//			JFrame frame = new JFrame();
//			JPanel panel = new JPanel();
//			JLabel label = new JLabel(gif);
//			frame.add(panel);
//			panel.add(label);
//			frame.setVisible(true);
//			frame.setLayout(null);
//			frame.setBounds(100, 100, 600, 600);
//			panel.setLayout(null);
//			panel.setBounds(0,0,600,600);
//			panel.setBackground(Color.BLUE);
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			
//			frame.setVisible(true);
//		}
//		});
//		
//		
		JLabel[] j ;
		j=new JLabel[2];
		
		j[1]=new JLabel("12");
		j[0]=new JLabel("15");
		List<JLabel> list = new ArrayList<>();
		
		list.add(j[0]);
		if(!list.contains(j[0]))
		list.add(j[0]);
		
		
		
		
		
		
		System.out.println(list.size());
		
		
		
		Set<Integer> set1=new HashSet<Integer>();
		Set<Integer> set2=new HashSet<Integer>();
		
		
		
		set1.add(1);
		set1.add(2);
		
		set1.add(3);
		set1.add(4);
		
		set1.add(5);
		set1.add(5);
		
		
		set2.add(1);
		set2.add(5);
		set2.add(6);
		set2.add(7);
		
		System.out.println(set1.toString());
		System.out.println(set2.toString());
		set2.removeAll(set1);
		System.out.println(set1.toString());
		System.out.println(set2.toString());
		
		
	}

}
