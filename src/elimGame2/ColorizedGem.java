package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

//6.	ͬһ�У�ͬһ�У������ͬ��ɫ��ʯ���������û�λ�ã��м�λ�ã�����һ���ɫ��Ч��ʯ���ñ�ʯ���Ժ�������ɫ��ʯ����������ʱ��ͬʱ������ʱ�������и���ɫ��ʯ��
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
