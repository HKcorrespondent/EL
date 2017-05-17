package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

public class CrossedGem extends CommonGem {

	


	
	static	Icon Crossed = new ImageIcon(JLabelTest.class.getResource("green.jpg"));
	public CrossedGem(BlockEnum c, int i, int j) {
		super(c);
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		label =new JLabelTest(i, j, c, 2, Crossed);
		
		
		
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
