package elimGameEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class Data {
	
	//用来测试的main函数
	//######################################
	public static void main(String[] args) {
		long startTime=System.nanoTime();   //获取开始时间  //记录程序开始时间
		
		// TODO Auto-generated method stub
		Data data = new Data();
		
		data.initializeData(5);
		
		data.showData(data.argsData);

		System.out.println();
		data.showData(data.isAbleElim());
		
		long endTime=System.nanoTime(); //获取结束时间 //记录程序结束时间
		System.out.println();
		System.out.println("程序运行时间： "+(endTime-startTime)/1000000D+"ms"); 
	}
	//#######################################
	
	//****************************************
	private final int height = 10;
	private final int width = 8;
	private int[][] argsData = new int[height][width];
	
	
	

	
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
	 * @param variety 作为图案的个数
	 */
	public void initializeData(int variety){
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				argsData[j][i]=(int)(Math.random()*variety+1);
			}
		}
		
	}
	
	
	/**
	 * 判断当前数组是否有可消除的情况,如果没有就返回null,否则返回一个数组,其中负数表示应该被消除的元素
	 * 后续处理时可以遍历数组单独针对负数进行处理
	 * @return 如果返回一个数组,其中负数表示应该被消除;如果返回null表示没有可消除的的情况
	 * 
	 */
	public int[][] isAbleElim(){
		int[][] argsData = new int[height][width];
		boolean ableElim = false;
		
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				argsData[j][i]=this.argsData[j][i];
			}
		}
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
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
//				List<Integer> nearij = this.getNear(i, j);
//				for(int ij : nearij){
//					if(argsData[j][i]==argsData[ij%100][ij/100]){
//						if(j==ij%100){
//							while(t<){
//								
//							}
//						}else{}
//					}
//				}
			}
		}	
		
		
		if(ableElim){
		
			return argsData;
		
		}else{
			return null;
		}
		
		
	}
	
	/**
	 * 根据的得到值 返回一个list,list中每个值的百位为横坐标,十位和各位为纵坐标
	 * 格式为(横坐标)(纵坐标)
	 * 例如709代表横坐标7纵坐标9
	 * @param i 作为数组横坐标,
	 * @param j 作为数组纵坐标,
	 * @return 一个list,拆分出
	 */
	public List<Integer> getNear(int i,int j){
		List<Integer> ret=new ArrayList<Integer>();
		if((i-1)>0)		{ret.add((i-1)*100+j);}
		if((i+1)<width)	{ret.add((i+1)*100+j);}
		if((j-1)>0)		{ret.add(i*100+(j-1));}
		if((j+1)<height){ret.add(i*100+(j+1));}

		return  ret;
}
}