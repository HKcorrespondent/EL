package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

//4.	ͬһ�У�ͬһ�У��Ŀ���ͬ��ɫ��ʯ���������û�λ�ò���һ����ͬ��ɫ��������Ч��ʯ�������ͬһ�У�ͬһ�У��Ŀ鱦ʯ�����������������Ч��ʯ����һ�α�����ʱ���Է�����Ч���������У��У����У��У��ı�ʯ��
//7.	ע�⣺������4��������5���ͬʱ����ʱ��������ɫ��ͬ��ʯ�������������û�λ�ò���һ����ͬ��ɫ��ʮ����Ч��ʯ����ʮ����Ч��ʯ������ʱ����������λ�����к��������б�ʯ��
public class LinearGem extends CommonGem {
	
	
	
	static	Icon Linear = new ImageIcon(JLabelTest.class.getResource("purple.jpg"));
	
	public LinearGem(BlockEnum c, int i, int j) {
		super(c);
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		label =new JLabelTest(i, j, c, 1, Linear);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public String getColor(){
		return this.color.colour+"��";
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
