package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

//4.	ͬһ�У�ͬһ�У��Ŀ���ͬ��ɫ��ʯ���������û�λ�ò���һ����ͬ��ɫ��������Ч��ʯ�������ͬһ�У�ͬһ�У��Ŀ鱦ʯ�����������������Ч��ʯ����һ�α�����ʱ���Է�����Ч���������У��У����У��У��ı�ʯ��
//7.	ע�⣺������4��������5���ͬʱ����ʱ��������ɫ��ͬ��ʯ�������������û�λ�ò���һ����ͬ��ɫ��ʮ����Ч��ʯ����ʮ����Ч��ʯ������ʱ����������λ�����к��������б�ʯ��
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
