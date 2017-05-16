package elimGame2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;





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
	
	
	
	
	private CommonGem[][] argsData ;
	private final int height ;
	private final int width ;
	
	
	public BlockArgsData(int h,int w){
		CommonGem.height=height = h;
		CommonGem.width=width = w;
		argsData = new CommonGem[height][width];
		
		
	}
	public CommonGem[][] getArgs(){
		return argsData;
		
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
							if(this.argsData[j][i].equals(this.argsData[t][i])){
								countj++;
								t--;
							}else{ break; }
							
						}
						t=j+1;
						while(t<height){
							if(this.argsData[j][i].equals(this.argsData[t][i])){
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
		private static List<CommonGem> changeList=new ArrayList<CommonGem>();
		/**
		 * 在调用该函数之前,应该确认已经将可消除的元素标记
		 * @return 返回一个List其中是应该被消除的方块的调用,并且把能升级为特效宝石的方块进行了升级
		 */	 
		
		public List<CommonGem> elim(){
			List<CommonGem> list=new ArrayList<CommonGem>();
			CommonGem.setClean();
			for(int i =0;i<width;i++){
				for(int j =0;j<height;j++){
					if(argsData[j][i].isElim){
						
						argsData[j][i].elim();
						
						
						
						
						
						
						
					}
				}
			}
			for(int t : CommonGem.getset()){
				System.out.println(t);
				int j=t/100;
				int i=t%100;
				list.add(argsData[j][i]);
				argsData[j][i]=argsData[j][i].levelUp();
				if(argsData[j][i]!=null){
					changeList.add(argsData[j][i]);
					argsData[j][i].getLabel().newGet=true;
				}
			}
			
			
			
			CommonGem.setClean();
			return list;
		}
		
		/**
		 * 掉落函数,在已经消除的情况下掉落,记录下每个宝石掉落的距离,计入数组drop中作为返回值，提供给动画制作。
		 * 
		 */	 
		 public List<CommonGem> drop(){
			 
			 
			 
			 int[][] drop=new int[height][width];
		
			 
			 int[] fail = new int[width];
			
				

				
			 for(int i=0;i<width;i++){
				 for(int j=0;j<height;j++){
					 if(argsData[j][i]==null){
						 fail[i]++;
						 for(int jabove = j-1;jabove>=0;jabove--){
							 if(argsData[jabove][i]!=null){
								 argsData[jabove][i].needMove++;
							 }
						 }										 
					 }
				 }
			 }
			 
			
			 
			 for(int i=0;i<width;i++){
				 for(int j=height-1;j>=0;j--){
					 if(argsData[j][i]!=null&&argsData[j][i].needMove!=0){
						 changeList.add(argsData[j][i]);
						 int move =argsData[j][i].move();
						 
						 
						 argsData[j+(move)][i]=argsData[j][i];
						 argsData[j][i]=null;
						 
					 }
				 }
			 
			 }
			 
			 
			
			
			 
			 for(int i=0;i<width;i++){
				 int move =fail[i];
				 
				 for(int j=height-1;j>=0;j--){
					 if(argsData[j][i]==null){
						 System.out.println(j+" "+i);
						 argsData[j][i]=new CommonGem(intTOcolor((int)(Math.random()*6+1)));
						 argsData[j][i].buildTopGem(i, j, move);

						 
						 
						 argsData[j][i].getLabel().newGet=true;
						 changeList.add(argsData[j][i]);
						 
					 }
					 
					 
					 
				 }
			}
			 
			 
			
			 
			 
			 
			 
			 
			 
			 
			
			 return changeList;
		 }
		 public void cleanChangelist(){
			 changeList.clear();
		 }
		
}
