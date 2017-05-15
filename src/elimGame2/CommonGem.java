package elimGame2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import swingTest.JLabelTest;

//2.	��ҿ����û��������鱦ʯ��λ�ã�ֻ������������������ͬ��ʯ��ͬһ�л�ͬһ�в��������ɹ�������û���δ�������ɹ������鱦ʯ�ص���ʼλ�á�
public class CommonGem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonGem cg =new CommonGem(BlockEnum.BLUE,0,0);
		CommonGem Lg =new CommonGem(BlockEnum.BLUE,1,1);
		
		System.out.println(cg.equals(Lg));
	}
	//######################################
	//######################################
	public static int height;
	public static int width;
	
	//������
	public int abscissa ;
	//������
	public int ordinate ;
	public final BlockEnum color ;
	//����ʱ��һ�������ķ������.��������������ͬ����Ч��ʯ
	
	int countAB = 0;
	int countOR = 0;
	//��ǰ״̬���Ƿ��ڿ�����״̬
	boolean isElim = false;
	//�Ƿ���Գ�Ϊ��Ч��ʯ
	boolean canLevelUp = false;
	//�÷���Ӧ�õ������
	int needMove = 0;
	//
	private JLabelTest label ;
	
	public JLabelTest getLabel(){
		return label;
		
	}
	
	
	public CommonGem(BlockEnum c,int i,int j) {
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		color=c;
		label =new JLabelTest(i, j, c);
	}

	/*
	 * ���ظ÷���Ӧ���ƶ��ľ���
	 * �ƶ���ָ�������ϴ������µľ���
	 */
	public int move(){
		ordinate+=needMove;
		label.goThere(ordinate,abscissa );
		int move =needMove;
		needMove= 0;
		return move;
		
	}
	
	protected static Set<Integer> set=new HashSet<Integer>();
	
	public static void	setClean(){
		set.clear();
		}
	
	public static Set<Integer>	getset(){
		
		return set;
		}
	
	public	void elim(){
			set.add(ordinate*100+abscissa);
			
			return ;
	}
	public CommonGem levelUp(){
		if(canLevelUp){
			if(countAB>4||countOR>4)
			{
				//you dian wen ti
				return new ColorizedGem(color, abscissa, ordinate);
			}
			
			if((countAB==4&&countOR==3)||(countAB==3&&countOR==4))
			{
				return new CrossedGem(color, abscissa, ordinate);
			}
			
			if(countAB==4||countOR==4)	
			{
				return new LinearGem(color, abscissa, ordinate);
			}	
			
			if(countAB==3&&countOR==3)
			{
				return new LShapeGem(color, abscissa, ordinate);
			}
			
			
			
		}
		return null;
	}
	public void renew(int j,int i){
		abscissa=i;
		ordinate=j;
		label.goThere(j,i);
		label.nowLocation.x=i*50;
		label.nowLocation.y=j*50;
		
	}
	
	
	 @Override
	public boolean equals(Object arg0) {
		 if(arg0 instanceof CommonGem){
			 if(this.color==((CommonGem)arg0).color)
				 return true;
		 }
		// TODO Auto-generated method stub
		 
		return false;
	}
	 
	 
	public String getColor(){
		return this.color.colour+"ɫ";
	} 
}
