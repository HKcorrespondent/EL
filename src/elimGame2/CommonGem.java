package elimGame2;
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
	protected int abscissa ;
	protected int ordinate ;
	public final BlockEnum color ;
	boolean isElim = false;
	boolean canLevelUp = false;
	public CommonGem(BlockEnum c,int i,int j) {
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		color=c;
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
}
