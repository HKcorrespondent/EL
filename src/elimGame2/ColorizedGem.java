package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

//6.	ͬһ�У�ͬһ�У������ͬ��ɫ��ʯ���������û�λ�ã��м�λ�ã�����һ���ɫ��Ч��ʯ���ñ�ʯ���Ժ�������ɫ��ʯ����������ʱ��ͬʱ������ʱ�������и���ɫ��ʯ��
public class ColorizedGem extends CommonGem {



	static	Icon colorized = new ImageIcon(JLabelTest.class.getResource("colorized.png"));
	
	public ColorizedGem(BlockEnum c, int i, int j) {
		super(BlockEnum.ELIM);
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		
		//�����ʯֵ10��
		gemScore=10;
		
		
		
		isColorizedGem=true;
		label =new JLabelTest(i, j, BlockEnum.ELIM, 4, colorized);
	}

	@Override
	public	void elim(){
		
		setEmilBySpecial.add(ordinate*100+abscissa);
		//problem
		if(elimByColor==BlockEnum.ELIM){
			for(int i =0;i<width;i++){
				for(int j=0;j<height;j++)
				setEmilBySpecial.add(j*100+i);
			}
		
		}else{
			final CommonGem[][] data=BlockArgsData.getArgs();
			for(int j=0;j<height;j++){
				for(int i=0;i<width;i++){
					if(data[j][i].color==elimByColor){
						setEmilBySpecial.add(data[j][i].ordinate*100+data[j][i].abscissa);
					}
				}
			}
			
		}
		
		
		
		
		
		
		
	
		
		return ;
}

}
