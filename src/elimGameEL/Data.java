package elimGameEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;

import java.util.Arrays;

class Point{
	int i;
	int j;
	Point(int hen,int zong){
		i=hen;
		j=zong;
	}	
}

public class Data {
	
	//用来测试的main函数
	//######################################
	public static void main(String[] args) {
		long startTime=System.nanoTime();   //获取开始时间  //记录程序开始时间
		
		// TODO Auto-generated method stub
		Data data = new Data(5,5,4);
		
		data.initializeData();
		
		data.showData(data.argsData);

		System.out.println();
		data.showData(data.isAbleElim());
		System.out.println(data.isDead());
		{
			Scanner in =new Scanner(System.in);
			System.out.println(
			data.exchangeloc(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()).size());
		}
		data.showData(data.argsData);
		long endTime=System.nanoTime(); //获取结束时间 //记录程序结束时间
		System.out.println();
		System.out.println("程序运行时间： "+(endTime-startTime)/1000000D+"ms"); 
	}
	//#######################################
	
	//****************************************
	private final int height ;
	private final int width ;
	private int[][] argsData ;
	private final int  variety;
	//****************************************
	/**
	 * 构造数组的结构框架
	 * @param h 为数组的高度(行数)
	 * @param w 为数组的宽度(列数)
	 * @param variety 数组中图案的种类
	 */
	Data(int h,int w,int variety){
		height = h;
		width = w;
		argsData = new int[height][width];
		this.variety=variety;
		
	}
	

	
	//***************************************
	/**
	 * 用来测试的时候显示数组的
	 */
	public void showData(int[][] data){
		if(data!=null){
			System.out.println("##  0  1  2  3  4  5  6  7 ");
			for(int i =0 ; i<height ; i++){
			System.out.println(" "+(i)+" "+Arrays.toString(data[i]));
			}
		
		}else{
			System.out.println("null");
		}
		
	}
	
	
	//***************************************
	/**
	 * 初始化数组,并且给每个位置填上1到variety
	 * 
	 */
	public void initializeData(){
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				argsData[j][i]=(int)(Math.random()*this.variety+1);
			}
		}
		while(isAbleElim()!=null){
			initializeData();
		}
		
		
	}
	
	
	/**
	 * 判断当前数组是否有可消除的情况,如果没有就返回null,否则返回一个数组,其中负数表示应该被消除的元素
	 * 后续处理时可以遍历数组单独针对负数进行处理
	 * @return 如果返回原数组的一个拷贝数组,其中负数表示应该被消除;如果返回null表示没有可消除的的情况
	 * 
	 */
	public int[][] isAbleElim(){
		int[][] argsData = new int[height][width];
		boolean ableElim = false;
		//可替换system.arrayCopy方法
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				argsData[j][i]=this.argsData[j][i];
			}
		}
		//单独对数组中的每个元素检查其周围元素,如果一旦不相同就返回
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				
				//先横向检查
				{
					int count =1;
					int t =i-1;
					while(t>=0){
						if(this.argsData[j][i]==this.argsData[j][t]){
							count++;
							t--;
						}else{ break; }
						
					}
					t=i+1;
					while(t<width){
						if(this.argsData[j][i]==this.argsData[j][t]){
							count++;
							t++;
						}else{ break; }
						
					}
					
					//即发现了三个连续的
					{
						if(count>2){
							ableElim = true;
							argsData[j][i]=-this.argsData[j][i];
							int s =i-1;
							while(s>=0){
								if(this.argsData[j][i]==this.argsData[j][s]){
									argsData[j][s]=-this.argsData[j][i];
									s--;
								}else{ break; }
								
							}
							s=i+1;
							while(s<width){
								if(this.argsData[j][i]==this.argsData[j][s]){
									argsData[j][s]=-this.argsData[j][i];
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
						if(this.argsData[j][i]==this.argsData[t][i]){
							countj++;
							t--;
						}else{ break; }
						
					}
					t=j+1;
					while(t<height){
						if(this.argsData[j][i]==this.argsData[t][i]){
							countj++;
							t++;
						}else{ break; }
						
					}
					
					//发现了三个连续的
					
					{
						if(countj>2){
							ableElim = true;
							argsData[j][i]=-this.argsData[j][i];
							int s =j-1;
							while(s>=0){
								if(this.argsData[j][i]==this.argsData[s][i]){
									argsData[s][i]=-this.argsData[j][i];
									s--;
								}else{ break; }
								
							}
							s=j+1;
							while(s<height){
								if(this.argsData[j][i]==this.argsData[s][i]){
									argsData[s][i]=-this.argsData[j][i];
									s++;
								}else{ break; }
								
							}
							
						}
						
					}
				
					
				}

			}
		}	
		
		
		if(ableElim){
		
			return argsData;
		
		}else{
			return null;
		}
		
		
	}
	
	/**
	 * 根据的得到值 返回一个list,list中每个值的百位为横坐标,十位和个位为纵坐标
	 * 格式为(横坐标)(纵坐标)
	 * 例如709代表横坐标7纵坐标9
	 * @param i 作为数组横坐标,
	 * @param j 作为数组纵坐标,
	 * @param k 与ji的距离
	 * @return 一个list,拆分出
	 */
	private List<Integer> getNear(int i,int j,int k){
		List<Integer> ret=new ArrayList<Integer>();
		if((i-k)>=0)		{ret.add((i-k)*100+j);}
		if((i+k)<width)	{ret.add((i+k)*100+j);}
		if((j-k)>=0)		{ret.add(i*100+(j-k));}
		if((j+k)<height){ret.add(i*100+(j+k));}

		return  ret;
	}
	private int checkArge(int j,int i){
		if(i>=0&&i<width&&j>=0&&j<height){
			return argsData[j][i];
		}else{
			return 0;
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
					
						if(argsData[j][i]==checkArge(j+1, i)){						
								if(argsData[j][i]==checkArge(j+2, i)||argsData[j][i]==checkArge(j-2, i)||argsData[j][i]==checkArge(j+2, i+1)||
								   argsData[j][i]==checkArge(j+2, i-1)||argsData[j][i]==checkArge(j-1, i-1)||argsData[j][i]==checkArge(j-1, i+1))
								{	return false; }else{System.out.println(j+" "+i+" "+(j+1)+" "+i);}														
						}
						
						if(argsData[j][i]==checkArge(j, i+1)){						
							if(argsData[j][i]==checkArge(j, i+2)||argsData[j][i]==checkArge(j, i-2)||argsData[j][i]==checkArge(j+1, i+2)||
							   argsData[j][i]==checkArge(j+1, i-1)||argsData[j][i]==checkArge(j-1, i-1)||argsData[j][i]==checkArge(j-1, i+2))
							{	return false; }else{System.out.println(j+" "+i+" "+(j)+" "+(i+1));}														
					}
						
					
				}
						
						
				{
					if(argsData[j][i]==checkArge(j+2, i)){
						if(argsData[j][i]==checkArge(j+1, i+1)||argsData[j][i]==checkArge(j+1, i-1))
								{	return false; }else{System.out.println(j+" "+i+" "+(j+2)+" "+i);}														
						}
					
					if(argsData[j][i]==checkArge(j, i+2)){						
						if(argsData[j][i]==checkArge(j-1, i+1)||argsData[j][i]==checkArge(j+1, i+1))
						{	return false; }else{System.out.println(j+" "+i+" "+(j)+" "+(i+2));}														
				}
				}
				
			}	
		}
		return isDead;
	}
	
	/**
	 * 根据玩家操作交换两个宝石的位置并判断交换后是否可消除，若可以则调用drop方法进行消除和宝石下落
	  
	 * @return null表示玩家操作后不可消除，失败；有值list用于动画制作
	 */
	
	public List<Point> exchangeloc(int j1,int i1,int j2,int i2){
		List<Point> list=new ArrayList<Point>();
		
		int temp=0;
		temp=argsData[j1][i1];
		argsData[j1][i1]=argsData[j2][i2];
		argsData[j2][i2]=temp;
		
		int[][] argsData1=isAbleElim();
		if(argsData1==null){
			argsData[j2][i2]=argsData[j1][i1];
			argsData[j1][i1]=temp;
			return null;
		}else{
			for(int i=0;i<width;i++){
				for(int j=0;j<height;j++){
					if(argsData1[j][i]<0){
						list.add(new Point(j,i));
					}
				}
			}													
			drop(argsData1);
			return list;
		}
	}
	
	/**
	 * 遍历矩阵，将所有可消位置用其上方的位置消除，并将最上方腾出的位置用新的随机宝石填充
	  
	 * @return
	 */
	
	public void drop(int[][] argsData2){
		for(int i=0;i<width;i++){ 
			for(int j=0;j<height;j++){
				if(argsData2[j][i]<0){
					for(int m=1;m<=j;m++){
						argsData[j-m+1][i]=argsData[j-m][i];
					}
					argsData[0][i]=(int)(Math.random()*this.variety+1);
				}
			}
		}
		if(isAbleElim()!=null){
			exchangeloc(isAbleElim());
		}
	}
	
	public List<Point> exchangeloc(int[][] argsData1){
		List<Point> list=new ArrayList<Point>();
			
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				if(argsData1[j][i]<0){
					list.add(new Point(j,i));
				}
			}
		}													
		drop(argsData1);
		return list;
	}
	
}