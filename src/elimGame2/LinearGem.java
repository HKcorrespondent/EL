package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

//4.	同一行（同一列）四块相同颜色宝石消除后在置换位置产生一块相同颜色的条形特效宝石。如果是同一行（同一列）四块宝石消除后产生的条形特效宝石在下一次被消除时可以发动特效消掉所处列（行）整列（行）的宝石；
//7.	注意：当规则4情况与规则5情况同时出现时（六块颜色相同宝石），消除后在置换位置产生一块相同颜色的十字特效宝石。该十字特效宝石被消除时会消除所处位置整行和整列所有宝石。
public class LinearGem extends CommonGem {
	
	
	
	static	Icon LinearBlue = new ImageIcon(JLabelTest.class.getResource("LinearBlue.png"));
	static	Icon LinearGreen = new ImageIcon(JLabelTest.class.getResource("LinearGreen.png"));
	static	Icon LinearOrange = new ImageIcon(JLabelTest.class.getResource("LinearOrange.png"));
	static	Icon LinearPurple = new ImageIcon(JLabelTest.class.getResource("LinearPurple.png"));
	static	Icon LinearRed = new ImageIcon(JLabelTest.class.getResource("LinearRed.png"));
	static	Icon LinearYellow = new ImageIcon(JLabelTest.class.getResource("LinearYellow.png"));
	
	
	
	
	public LinearGem(BlockEnum c, int i, int j) {
		super(c);
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		switch(c){
		case BLUE:
			label =new JLabelTest(i, j, c, 1, LinearBlue);
			break;
		case ELIM:
			break;
		case GREEN:
			label =new JLabelTest(i, j, c, 1, LinearGreen);
			break;
		case PURPLE:
			label =new JLabelTest(i, j, c, 1, LinearPurple);
			break;
		case RED:
			label =new JLabelTest(i, j, c, 1, LinearRed);
			break;
		case WHITE:
			label =new JLabelTest(i, j, c, 1, LinearOrange);
			break;
		case YELLOW:
			label =new JLabelTest(i, j, c, 1, LinearYellow);
			break;
		default:
			break;

			
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public String getColor(){
		return this.color.colour+"长";
	}
	
	@Override
	public	void elim(){
		//problem
		if(countAB>=countOR){
			for(int i =0;i<width;i++){
				set.add(ordinate*100+i);
			}
		}else{
			for(int j=0;j<height;j++){
				set.add(j*100+abscissa);
			}
		}
		
		
		
		
		
		
		
		
	
		
		return ;
}
	
}
