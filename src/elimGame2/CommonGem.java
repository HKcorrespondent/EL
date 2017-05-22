package elimGame2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.sun.prism.Image;

import sun.awt.image.GifImageDecoder;
import swingGUI.JLabelTest;

//2.	玩家可以置换相邻两块宝石的位置，只有三个或三个以上相同宝石在同一行或同一列才能消除成功，如果置换后未能消除成功则两块宝石回到初始位置。
public class CommonGem implements Runnable {
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonGem cg =new CommonGem(BlockEnum.BLUE,0,0);
		CommonGem Lg =new CommonGem(BlockEnum.BLUE,1,1);
		
		System.out.println(cg.equals(Lg));
	}
	//######################################
	
	
//	static	java.net.URL imgURLCommonGif = JLabelTest.class.getResource("commonGem.gif");
//	static	Icon gif = new ImageIcon(imgURLCommonGif);
	//######################################
	public static int height;
	public static int width;
	//这个方块的价值
	protected int gemScore;
	//横坐标
	public int abscissa ;
	//纵坐标
	public int ordinate ;
	public final BlockEnum color ;
	//消除时的一起消除的方块个数.可以用来产生不同的特效宝石
	
	int countAB = 0;
	int countOR = 0;
	//当前状态下是否处于可消除状态
	boolean isElim = false;
	//是否可以成为特效宝石
	boolean canLevelUp = false;
	//该方块应该掉落多少
	int needMove = 0;
	//
	protected JLabelTest label ;
	
	
	
	boolean isColorizedGem =false;
	BlockEnum elimByColor =null;
	
	public JLabelTest getLabel(){
		return label;
		
	}
	//用来特殊构造的构造器
	public CommonGem(BlockEnum c){
		color=c;
		
	}
	
	
	
	
	
	//用来一般构造的构造器
	public CommonGem(BlockEnum c,int i,int j) {
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		color=c;
		label =new JLabelTest(i, j, c);
		gemScore=100;
	}

	
	
	
	
	/**
	 * 返回该方块应该移动的距离
	 * 移动是指在坐标上从上往下的距离
	 * 	
	 */
	public int move(){
		ordinate+=needMove;
		label.goThere(ordinate,abscissa );
		int move =needMove;
		needMove= 0;
		return move;
		
	}
	
	protected static Set<Integer> set=new HashSet<Integer>();
	protected static Set<Integer> setEmilBySpecial=new HashSet<Integer>();
	public static void	setClean(){
		set.clear();
		setEmilBySpecial.clear();
		}
	
	public static Set<Integer>	getset(){
		
		return set;
		}
	public static Set<Integer>	getNotCommonElimSet(){
		
		setEmilBySpecial.removeAll(set);
			
		return setEmilBySpecial;
			
		}
	
	
	
	
	
	public	void elim(){
			set.add(ordinate*100+abscissa);
			
			return ;
	}
	/**
	 * 构造顶层新制宝石时调用
	 */

	public void buildTopGem(int i,int j,int move){
		abscissa = i;
		ordinate=j;
		label =new JLabelTest(i, j-move, color);
		label.goThere(j, i);
	}
	
	
	public CommonGem levelUp(){
		if(canLevelUp){
			if(countAB>4||countOR>4)
			{
				
				return new ColorizedGem(color, abscissa, ordinate);
			}
			
			
			
			if(countAB==4||countOR==4)	
			{
				
				return new LinearGem(color, abscissa, ordinate,countAB>countOR);
			}	
			
	
		}
		
		if((countAB==4&&countOR==3)||(countAB==3&&countOR==4))
		{
			
			return new CrossedGem(color, abscissa, ordinate);
		}
		
		if(countAB==3&&countOR==3)
		{
			
			return new LShapeGem(color, abscissa, ordinate);
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
		return this.color.colour+"色";
	}

	
	//暂时作废******************************************

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int x =label.nowLocation.x;
		int y =label.nowLocation.y;
//		gif.paintIcon(label, null, x, y);
		
		
		
		
	} 
	
	//***********************************************
	
	
	/**
	 * 得到这个元素的分值其中一般宝石计1分,特殊宝石计5分,超强宝石(彩色宝石)计10分
	 * 请注意对同一个元素重复调用该函数将会返回0;
	 */
	public int getGemScore(){
		
		int score = gemScore;
		gemScore=0;
		
		
		
		return score;
	}
}
