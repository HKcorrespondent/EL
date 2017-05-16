package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

//6.	同一行（同一列）五块相同颜色宝石消除后在置换位置（中间位置）产生一块彩色特效宝石，该宝石可以和任意颜色宝石消除，消除时会同时消掉此时场上所有该颜色宝石。
public class ColorizedGem extends CommonGem {



	static	Icon colorized = new ImageIcon(JLabelTest.class.getResource("colorized.png"));

	public ColorizedGem(BlockEnum c, int i, int j) {
		super(c);
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		isColorizedGem=true;
		label =new JLabelTest(i, j, c, 4, colorized);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
