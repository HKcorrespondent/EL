package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

//5.	以L形的方式消除的五块相同颜色宝石消除后在置换位置（交点位置）产生一块相同颜色的爆炸特效宝石，爆炸特效宝石被消除时会消除以它为中心的九宫格内的所有宝石。
//7.	注意：当规则4情况与规则5情况同时出现时（六块颜色相同宝石），消除后在置换位置产生一块相同颜色的十字特效宝石。该十字特效宝石被消除时会消除所处位置整行和整列所有宝石。
public class LShapeGem extends CommonGem {

	

	static	Icon LShape = new ImageIcon(JLabelTest.class.getResource("blue.jpg"));
	
	public LShapeGem(BlockEnum c, int i, int j) {
		super(c);
		abscissa = i;
		ordinate=j;
		label =new JLabelTest(i, j, c, 3, LShape);
	}
	
	@Override
	public	void elim(){
		//problem
		
			for(int i =abscissa-1;i<=abscissa+1;i++){
				for(int j =ordinate-1;j<=ordinate+1;j++){
					setEmilBySpecial.add(check(j,i));
				}
			}

		return ;
	}
	
	private Integer check(int j ,int i){
		if(i>=0&&i<width){
			if(j>=0&&j<height){
				return j*100+i;
			}
		}
		
		
		return null;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String getColor(){
		return this.color.colour+"L";
	}
}