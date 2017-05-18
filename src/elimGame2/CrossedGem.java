package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

public class CrossedGem extends CommonGem {

	
	static	Icon CrossedBlue = new ImageIcon(JLabelTest.class.getResource("CrossedBlue.png"));
	static	Icon CrossedGreen = new ImageIcon(JLabelTest.class.getResource("CrossedGreen.png"));
	static	Icon CrossedOrange = new ImageIcon(JLabelTest.class.getResource("CrossedOrange.png"));
	static	Icon CrossedPurple = new ImageIcon(JLabelTest.class.getResource("CrossedPurple.png"));
	static	Icon CrossedRed = new ImageIcon(JLabelTest.class.getResource("CrossedRed.png"));
	static	Icon CrossedYellow = new ImageIcon(JLabelTest.class.getResource("CrossedYellow.png"));

	
	static	Icon Crossed = new ImageIcon(JLabelTest.class.getResource("green.jpg"));
	public CrossedGem(BlockEnum c, int i, int j) {
		super(c);
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		
		
		
		//这个宝石值5分
		gemScore=5;
		
		switch(c){
		case BLUE:
			label =new JLabelTest(i, j, c, 1, CrossedBlue);
			break;
		case ELIM:
			break;
		case GREEN:
			label =new JLabelTest(i, j, c, 1, CrossedGreen);
			break;
		case PURPLE:
			label =new JLabelTest(i, j, c, 1, CrossedPurple);
			break;
		case RED:
			label =new JLabelTest(i, j, c, 1, CrossedRed);
			break;
		case WHITE:
			label =new JLabelTest(i, j, c, 1, CrossedOrange);
			break;
		case YELLOW:
			label =new JLabelTest(i, j, c, 1, CrossedYellow);
			break;
		default:
			break;

			
		}		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public	void elim(){
		//problem
		
			for(int i =0;i<width;i++){
				setEmilBySpecial.add(ordinate*100+i);
			}
			
			for(int j=0;j<height;j++){
				setEmilBySpecial.add(j*100+abscissa);
			}
		
		
		
		
		
		
		
		
		
	
		
		return ;
	}
}
