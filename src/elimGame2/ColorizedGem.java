package elimGame2;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import swingTest.JLabelTest;

//6.	同一行（同一列）五块相同颜色宝石消除后在置换位置（中间位置）产生一块彩色特效宝石，该宝石可以和任意颜色宝石消除，消除时会同时消掉此时场上所有该颜色宝石。
public class ColorizedGem extends CommonGem {



	static	Icon colorized = new ImageIcon(JLabelTest.class.getResource("colorized.png"));
	
	public ColorizedGem(BlockEnum c, int i, int j) {
		super(BlockEnum.ELIM);
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		
		//这个宝石值10分
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
