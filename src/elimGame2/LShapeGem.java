package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

//5.	��L�εķ�ʽ�����������ͬ��ɫ��ʯ���������û�λ�ã�����λ�ã�����һ����ͬ��ɫ�ı�ը��Ч��ʯ����ը��Ч��ʯ������ʱ����������Ϊ���ĵľŹ����ڵ����б�ʯ��
//7.	ע�⣺������4��������5���ͬʱ����ʱ��������ɫ��ͬ��ʯ�������������û�λ�ò���һ����ͬ��ɫ��ʮ����Ч��ʯ����ʮ����Ч��ʯ������ʱ����������λ�����к��������б�ʯ��
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