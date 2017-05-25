package elimGame2;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.ImageIcon;

import swingGUI.MainJFrame;

 class Score {

	public final static	Image scoreImage = new ImageIcon(MainJFrame.class.getResource("score.png")).getImage();
	public final static	Image score0 = new ImageIcon(MainJFrame.class.getResource("n0.png")).getImage();
	public final static	Image score1 = new ImageIcon(MainJFrame.class.getResource("n1.png")).getImage();
	public final static	Image score2 = new ImageIcon(MainJFrame.class.getResource("n2.png")).getImage();
	public final static	Image score3 = new ImageIcon(MainJFrame.class.getResource("n3.png")).getImage();
	public final static	Image score4 = new ImageIcon(MainJFrame.class.getResource("n4.png")).getImage();
	public final static	Image score5 = new ImageIcon(MainJFrame.class.getResource("n5.png")).getImage();
	public final static	Image score6 = new ImageIcon(MainJFrame.class.getResource("n6.png")).getImage();
	public final static	Image score7 = new ImageIcon(MainJFrame.class.getResource("n7.png")).getImage();
	public final static	Image score8 = new ImageIcon(MainJFrame.class.getResource("n8.png")).getImage();
	public final static	Image score9 = new ImageIcon(MainJFrame.class.getResource("n9.png")).getImage();
	
	public static Image getImage(int i){
		switch(i){
		case 0:
			return score0;
		case 1:
			return score1;
		case 2:
			return score2;
		case 3:
//			System.out.println("return null");
			return score3;
		case 4:
			return score4;
		case 5:
			return score5;
		case 6:
			return score6;
		case 7:
			return score7;
		case 8:
			return score8;
		case 9:
			
			return score9;
		default:
			return scoreImage;
		}
		
	}
	
	
}



public class BlockArgsData {
//	public static void main(String[] args) {
//		long startTime=System.nanoTime();   //获取开始时间  //记录程序开始时间
//		System.out.println((int)(Math.random()*6+1));
//		
//		BlockArgsData data = new BlockArgsData(5, 5);
//		data.initializeData();
//		data.argsData[0][0]=new CommonGem(BlockEnum.YELLOW, 0, 0);
//		data.argsData[0][1]=new LinearGem(BlockEnum.BLUE, 1, 0);
//		data.argsData[0][2]=new CommonGem(BlockEnum.RED, 2, 0);
//		data.argsData[0][3]=new CommonGem(BlockEnum.BLUE, 3, 0);
//		data.argsData[0][4]=new CommonGem(BlockEnum.YELLOW, 4, 0);
//		
//		data.argsData[1][0]=new CommonGem(BlockEnum.BLUE, 0, 1);
//		data.argsData[1][1]=new CommonGem(BlockEnum.RED, 1, 1);
//		data.argsData[1][2]=new CommonGem(BlockEnum.BLUE, 2, 1);
//		data.argsData[1][3]=new CommonGem(BlockEnum.BLUE, 3, 1);
//		data.argsData[1][4]=new CommonGem(BlockEnum.YELLOW, 4, 1);
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		data.showData(data.argsData);
//		System.out.println();
//		data.isAbleElim();
//		data.showData(data.argsData);
//		
//		System.out.println("isDead: "+data.isDead());
//		
//		int i=0;
//		while(i<10){
//			Scanner in =new Scanner(System.in);
//			System.out.println(
//			data.exchangeloc(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
//			System.out.println(data.elim().size());
//			data.showData(data.argsData);
//			data.drop();
//			data.showData(data.argsData);
//		}
//		
//		
//	}
	
	
	
	
	private static CommonGem[][] argsData ;
	private final int height ;
	private final int width ;
	//用来计算得分
	static long score =0;
	private static Image[] Images=new Image[6];
	
	public static Image[] getScoreImage(){

		Images[0]=Score.scoreImage;
		Images[1]=Score.getImage((int)((score%100000)/10000));
		Images[2]=Score.getImage((int)((score%10000)/1000));
		Images[3]=Score.getImage((int)((score%1000)/100));

		Images[4]=Score.getImage((int)((score%100)/10));
		Images[5]=Score.getImage((int)(score%10));
		return Images;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BlockArgsData(int h,int w){
		CommonGem.height=height = h;
		CommonGem.width=width = w;
		argsData = new CommonGem[height][width];
		
		
	}
	public static CommonGem[][] getArgs(){
		return argsData;
		
	}
	
	
	/**
	 * 测试时产生特殊情况
	 * @param data
	 */
	public static void test(CommonGem[][] data){

//		data[1][4]=new CommonGem(BlockEnum.YELLOW, 4, 1);
	}
	
	
	
	
	//***************************************
		/**
		 * 用来测试的时候显示数组的
		 */
		public void showData(CommonGem[][] data){
			if(data!=null){
				System.out.println("##  0   1   2   3   4   5   6    7 ");
				for(int j =0;j<height;j++){
					System.out.print(j+"  ");
					for(int i =0;i<width;i++){
						if(argsData[j][i]==null){
							System.out.print("蛤蛤"+"    ");
							
							continue;
						}
						if(argsData[j][i].isElim){
//						System.out.print("叉叉"+"    ");
						System.out.print(argsData[j][i].getColor()+"    ");
						}else{
						System.out.print(argsData[j][i].getColor()+"    ");
					
						}
					}
					System.out.println();
				}
			}else{
				System.out.println("null");
			}
			
		}
	
	//***************************************
		/**
		 * 初始化数组,并且给每个位置填上宝石
		 * 
		 */
		public void initializeData(){
			for(int i =0;i<width;i++){
				for(int j =0;j<height;j++){
					argsData[j][i]=new CommonGem(intTOcolor((int)(Math.random()*6+1)), i, j);
				}
			}
			while(this.isAbleElim()!=false){
				for(int i =0;i<width;i++){
					for(int j =0;j<height;j++){
						if(argsData[j][i].isElim==true){
							argsData[j][i]=new CommonGem(intTOcolor((int)(Math.random()*6+1)), i, j);        //?
						}
					}
				}
			}
		}
		
		private BlockEnum intTOcolor(int i){
			switch(i){
			case 1:
				return BlockEnum.RED;
				
			case 2:
				return BlockEnum.GREEN;
					
			case 3:
				return BlockEnum.WHITE;
				
			case 4:
				return BlockEnum.YELLOW;
				
			case 5:
				return BlockEnum.PURPLE;
				
			case 6:
				return BlockEnum.BLUE;
			default:
				return BlockEnum.ELIM;
			}
			
		}
			
		/**
		 * 判断当前数组是否有可消除的情况,如果没有就返回false,否则返回true,并将应该被消除的元素的iselim改为true
		 * 
		 * @return true或者false
		 * 
		 */
		public boolean isAbleElim(){
			
			boolean ableElim = false;
			//可替换system.arrayCopy方法
		
			//单独对数组中的每个元素检查其周围元素,如果一旦不相同就返回
			for(int i =0;i<width;i++){
				for(int j =0;j<height;j++){
					
					//先横向检查
					{
						int count =1;
						int t =i-1;
						while(t>=0){
							if(this.argsData[j][i].equals(this.argsData[j][t])){
								count++;
								t--;
							}else{ break; }
							
						}
						t=i+1;
						while(t<width){
							if(this.argsData[j][i].equals(this.argsData[j][t])){
								count++;
								t++;
							}else{ break; }
							
						}
						
						//即发现了三个横向连续的
						{
							if(count>2){
								
								ableElim = true;
								
								argsData[j][i].isElim=true;
								argsData[j][i].countAB=count;
								int s =i-1;
								while(s>=0){
									if(this.argsData[j][i].equals(this.argsData[j][s])){
										argsData[j][s].isElim=true;
										argsData[j][s].countAB=count;
										s--;
									}else{ break; }
									
								}
								s=i+1;
								while(s<width){
									if(this.argsData[j][i].equals(this.argsData[j][s])){
										argsData[j][s].isElim=true;
										argsData[j][s].countAB=count;
										s++;
									}else{ break; }
									
								}
								
							}
						}
					
						
					}
					
					//纵向检查
					
					{
						int countj =1;
						int t =j-1;
						while(t>=0){
							if(argsData[j][i].equals(argsData[t][i])){
								countj++;
								t--;
							}else{ break; }
							
						}
						t=j+1;
						while(t<height){
							if(argsData[j][i].equals(argsData[t][i])){
								countj++;
								t++;
							}else{ break; }
							
						}
						
						//发现了三个连续的
						
						{
							if(countj>2){
								ableElim = true;
								argsData[j][i].isElim=true;
								argsData[j][i].countOR=countj;
								int s =j-1;
								while(s>=0){
									
									if(this.argsData[j][i].equals(this.argsData[s][i])){
										argsData[s][i].isElim=true;
										argsData[s][i].countOR=countj;
										s--;
									}else{ break; }
									
								}
								s=j+1;
								while(s<height){
								
									if(this.argsData[j][i].equals(this.argsData[s][i])){
										argsData[s][i].isElim=true;
										argsData[s][i].countOR=countj;
										s++;
									}else{ break; }
									
								}
								
							}
							
						}
					
						
					}

				}
			}	
			
			
				return ableElim;
			
			
			
		}
		
		public CommonGem checkArge(int j,int i){
			if(i>=0&&i<width&&j>=0&&j<height){
				return argsData[j][i];
			}else{
				return null;
			}
		}
		
		/**
		 * 判断当前数组是否为死图
		  
		 * @return true表示死图,false表示不是死图
		 */
		public boolean isDead(){
			boolean isDead =true;
			for(int i =0;i<width;i++){
				for(int j =0;j<height;j++){
					
					{
						
							if(argsData[j][i].equals(checkArge(j+1, i))){						
									if(argsData[j][i].equals(checkArge(j+2, i))||argsData[j][i].equals(checkArge(j-2, i))||argsData[j][i].equals(checkArge(j+2, i+1))||
									   argsData[j][i].equals(checkArge(j+2, i-1))||argsData[j][i].equals(checkArge(j-1, i-1))||argsData[j][i].equals(checkArge(j-1, i+1)))
									{	return false; }else{System.out.println(j+" "+i+" "+(j+1)+" "+i);}														
							}
							
							if(argsData[j][i].equals(checkArge(j, i+1))){						
								if(argsData[j][i].equals(checkArge(j, i+2))||argsData[j][i].equals(checkArge(j, i-2))||argsData[j][i].equals(checkArge(j+1, i+2))||
								   argsData[j][i].equals(checkArge(j+1, i-1))||argsData[j][i].equals(checkArge(j-1, i-1))||argsData[j][i].equals(checkArge(j-1, i+2)))
								{	return false; }else{System.out.println(j+" "+i+" "+(j)+" "+(i+1));}														
						}
							
						
					}
							
							
					{
						if(argsData[j][i].equals(checkArge(j+2, i))){
							if(argsData[j][i].equals(checkArge(j+1, i+1))||argsData[j][i].equals(checkArge(j+1, i-1)))
									{	return false; }else{System.out.println(j+" "+i+" "+(j+2)+" "+i);}														
							}
						
						if(argsData[j][i].equals(checkArge(j, i+2))){						
							if(argsData[j][i].equals(checkArge(j-1, i+1))||argsData[j][i].equals(checkArge(j+1, i+1)))
							{	return false; }else{System.out.println(j+" "+i+" "+(j)+" "+(i+2));}														
					}
					}
					
				}	
			}
			return isDead;
		}
		
		/**
		 * 根据玩家操作交换两个宝石的位置并判断交换后是否可消除，调用isAbleElim方法.如果不能消除,数组不变,如果能消除,数组已发生交换,并将可消除的元素的isElim标记为true;
		  
		 * @return true 表示现在的情况数组内已交换可以产生消除 ,false表示不可消除,数组返回原样
		 */
		
		public boolean exchangeloc(int j1,int i1,int j2,int i2){

			CommonGem gem1=checkArge(j1, i1);
			CommonGem gem2=checkArge(j2, i2);
			
			
			
			
			if(gem1!=null&&gem2!=null){
				//如果交换中出现彩色宝石
					{
						
						if(gem1.isColorizedGem||(gem2.isColorizedGem)){
							gem2.isElim=true;
							gem1.isElim=true;
							if(gem1.isColorizedGem){
								gem1.elimByColor=gem2.color;
							
							}else{
								gem2.elimByColor=gem1.color;
								
							}
							
							
							
							return true;
						}

					}
				
				argsData[j2][i2]=gem1;
				argsData[j1][i1]=gem2;
				if(isAbleElim()){
					
					if(argsData[j2][i2].isElim==true){
						argsData[j2][i2].canLevelUp=true;
					}
					if(argsData[j1][i1].isElim==true){
						argsData[j1][i1].canLevelUp=true;
					}
					int x =argsData[j2][i2].abscissa;
					int y =argsData[j2][i2].ordinate;
					
					argsData[j2][i2].abscissa=argsData[j1][i1].abscissa;
					argsData[j2][i2].ordinate=argsData[j1][i1].ordinate;
					argsData[j1][i1].abscissa=x;
					argsData[j1][i1].ordinate=y;
					
					
					return true;
				}else{
					argsData[j2][i2]=gem2;
					argsData[j1][i1]=gem1;
					return false;
				}
			}else{
				return false;
			}
			
		}
		//用来得到新产生的方块或者新升级的方块
		private static List<CommonGem> changeList=new ArrayList<CommonGem>();
		/**
		 * 在调用该函数之前,应该确认已经将可消除的元素标记,该函数会消除所有被标记元素并且如果其不能升级将在数组中置null,能升级的元素将会升级
		 * @return 返回一个List其中是应该被消除的方块的调用,并且把能升级为特效宝石的方块进行了升级
		 */	 
		
		public List<CommonGem> elim(){
			List<CommonGem> elimList=new ArrayList<CommonGem>();
			for(int i =0;i<width;i++){
				for(int j =0;j<height;j++){
					if(argsData[j][i].isElim){
						
						argsData[j][i].elim();
						
						
						
						
						
						
						
					}
				}
			}
			
			//对所有非正常消除的元素处理
			int size=0;
			HashSet<Integer> notCommonElimSet=(HashSet<Integer>) ((HashSet<Integer>) CommonGem.getNotCommonElimSet()).clone();
			
			while(notCommonElimSet.size()!=size){
			 size=notCommonElimSet.size();
			 for(int t : notCommonElimSet){
//					System.out.println(t);
					int j=t/100;
					int i=t%100;
					argsData[j][i].elim();
			 }
			notCommonElimSet=(HashSet<Integer>) ((HashSet<Integer>) CommonGem.getNotCommonElimSet()).clone();
			
			 
			}
			System.out.println("notCommonElimSet="+notCommonElimSet.size());
			for(int t : notCommonElimSet){
//				System.out.println(t);
				int j=t/100;
				int i=t%100;
				elimList.add(argsData[j][i]);
				
				//加分
				score+=argsData[j][i].getGemScore();
				
				//升级元素并加到清单中
				argsData[j][i]=argsData[j][i].levelUp();
				if(argsData[j][i]!=null){
					changeList.add(argsData[j][i]);
					argsData[j][i].getLabel().newGet=true;
				}
			}
			//对所有的被一般消除的元素加到list中
			System.out.println("CommonElimSet="+CommonGem.getset().size());
			for(int t : CommonGem.getset()){
//				System.out.println(t);
				int j=t/100;
				int i=t%100;
				elimList.add(argsData[j][i]);
				
				//加分
				score+=argsData[j][i].getGemScore();
				
				//升级元素并加到清单中
				argsData[j][i]=argsData[j][i].levelUp();
				if(argsData[j][i]!=null){
					changeList.add(argsData[j][i]);
					argsData[j][i].getLabel().newGet=true;
				}
			}
			
			
			
			CommonGem.setClean();
			
			
			
			
			
			return elimList;
		}
		
		/**
		 * 掉落函数,在已经消除的情况下掉落,返回产生了掉落的方块.
		 * 
		 */	 
		 public List<CommonGem> drop(){
			 
			 
			 
			 //这个数组用来计算一列的被消掉的元素数量
			 
			 int[] fail = new int[width];
			
				//首先

				
			 for(int i=0;i<width;i++){
				 for(int j=0;j<height;j++){
					 if(argsData[j][i]==null){
						 
						 fail[i]++;
						 //在找到了一个被消除的元素之后将上方的元素标记,意味着他们将会掉落一格
						 for(int jabove = j-1;jabove>=0;jabove--){
							 if(argsData[jabove][i]!=null){
								 argsData[jabove][i].needMove++;
							 }
						 }										 
					 }
				 }
			 }
			 
			//在数据数组中先移动方块,腾出位置给上方新产生方块
			 
			 for(int i=0;i<width;i++){
				 for(int j=height-1;j>=0;j--){
					 if(argsData[j][i]!=null&&argsData[j][i].needMove!=0){
						 changeList.add(argsData[j][i]);
						 int move =argsData[j][i].move();
						 
						 argsData[j+(move)][i]=argsData[j][i];
						 
						 //新的方块按理应该能升级,但是还没有考虑两块一样颜色的发生特效消除时都变成特效方块
						 argsData[j+(move)][i].canLevelUp=true;
						 
						 argsData[j][i]=null;
						 
					 }
				 }
			 
			 }
			 
			 
			
			
			 //在最上方生成新的方块
			 for(int i=0;i<width;i++){
				 int move =fail[i];
				 
				 for(int j=height-1;j>=0;j--){
					 if(argsData[j][i]==null){
						 System.out.println(j+" "+i);
						 argsData[j][i]=new CommonGem(intTOcolor((int)(Math.random()*6+1)));
						 argsData[j][i].buildTopGem(i, j, move);

						 //新的方块按理应该能升级,但是还没有考虑两块一样颜色的发生特效消除时都变成特效方块
						 argsData[j][i].canLevelUp=true;
						 
						 argsData[j][i].getLabel().newGet=true;
						 changeList.add(argsData[j][i]);
						 
					 }
					 
					 
					 
				 }
			}
			 
			 
			
			 
			 
			 
			 
			 
			 deleteOneMoreLevelUP();
			 
			
			 return changeList;
		 }
		 
		 
		 //在一次消除结束后刷新数据数组
		 public void cleanChangelist(){
			 changeList.clear();
			 
			 
			 
			 
		 }
		 
		 /**
		  * 消除这个bug //新的方块按理应该能升级,但是还没有考虑两块一样颜色的发生特效消除时都变成特效方块
		  */
		 private void deleteOneMoreLevelUP(){
			 
			 for(int j =0;j<height-1;j++){
				 for(int i=0;i<width-1;i++){
					 if(argsData[j][i].canLevelUp==true&&argsData[j][i].color==argsData[j+1][i].color&&argsData[j+1][i].canLevelUp==true){
						 int count=2;
						 {
								
								int t =j-1;
							 	while(t>=0){
									if(argsData[j][i].equals(argsData[t][i])){
										count++;
										t--;
									}else{ break; }
									
								}
								t=j+2;
								while(t<height){
									if(this.argsData[j][i].equals(this.argsData[t][i])){
										count++;
										t++;
									}else{ break; }
									
								}
						 
						 
						 }
						 if(count>=4){
							 int s=j+1;
							 while(s<width&&argsData[s][i].canLevelUp==true){
								 argsData[s][i].canLevelUp=false;
								 s++;
								 
							 }
						 
						 }
						 
					 }
					 if(argsData[j][i].canLevelUp==true&&argsData[j][i].color==argsData[j][i+1].color&&argsData[j][i+1].canLevelUp==true){
						 
						int count=2;
						 {
								
								int t =i-1;
							 	while(t>=0){
									if(argsData[j][i].equals(argsData[j][t])){
										count++;
										t--;
									}else{ break; }
									
								}
								t=i+2;
								while(t<width){
									if(this.argsData[j][i].equals(this.argsData[j][t])){
										count++;
										t++;
									}else{ break; }
									
								}
						 
						 
						 }
						 if(count>=4){
							 int s=i+1;
							 while(s<width&&argsData[j][s].canLevelUp==true){
								 argsData[j][s].canLevelUp=false;
								 s++;
								 
							 }
						 
						 }
						 
						 
					 }
				 }
			 }
		 }
		 
		 
		 
		 
		 
		 
		//在一次消除结束后刷新数据数组
		 public void cleanLevelUp(){
			
			 for(int j =0;j<height;j++){
				 for(int i=0;i<width;i++){
					 if(argsData[j][i]!=null)
					 argsData[j][i].canLevelUp=false; 
				 }
			 }
			 
			 
			 
		 }
		 

		
}
