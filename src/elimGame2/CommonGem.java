package elimGame2;

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
	//������
	protected int abscissa ;
	//������
	protected int ordinate ;
	public final BlockEnum color ;
	//����ʱ��һ�������ķ������.��������������ͬ����Ч��ʯ
	
	int countAB = 0;
	int countOR = 0;
	//��ǰ״̬���Ƿ��ڿ�����״̬
	boolean isElim = false;
	//�Ƿ���Գ�Ϊ��Ч��ʯ
	boolean canLevelUp = false;
	//�÷���Ӧ�õ������
	private int needMove = 0;
	//
	JLabelTest label ;
	
	public JLabelTest getLabel(){
		return label;
		
	}
	
	
	public CommonGem(BlockEnum c,int i,int j) {
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		color=c;
		label =new JLabelTest(i*50, j*50, c);
	}

	/*
	 * ���ظ÷���Ӧ���ƶ��ľ���
	 * �ƶ���ָ�������ϴ������µľ���
	 */
	public int move(){
		int move =needMove;
		needMove= 0;
		return move;
		
	}
	public CommonGem elim(){
		
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
