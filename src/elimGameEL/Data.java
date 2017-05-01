package elimGameEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class Data {
	
	//�������Ե�main����
	//######################################
	public static void main(String[] args) {
		long startTime=System.nanoTime();   //��ȡ��ʼʱ��  //��¼����ʼʱ��
		
		// TODO Auto-generated method stub
		Data data = new Data();
		
		data.initializeData(5);
		
		data.showData(data.argsData);

		System.out.println();
		data.showData(data.isAbleElim());
		
		long endTime=System.nanoTime(); //��ȡ����ʱ�� //��¼�������ʱ��
		System.out.println();
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)/1000000D+"ms"); 
	}
	//#######################################
	
	//****************************************
	private final int height = 10;
	private final int width = 8;
	private int[][] argsData = new int[height][width];
	
	
	

	
	//***************************************
	/**
	 * �������Ե�ʱ����ʾ�����
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
	 * ��ʼ������,���Ҹ�ÿ��λ������1��variety
	 * @param variety ��Ϊͼ���ĸ���
	 */
	public void initializeData(int variety){
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				argsData[j][i]=(int)(Math.random()*variety+1);
			}
		}
		
	}
	
	
	/**
	 * �жϵ�ǰ�����Ƿ��п����������,���û�оͷ���null,���򷵻�һ������,���и�����ʾӦ�ñ�������Ԫ��
	 * ��������ʱ���Ա������鵥����Ը������д���
	 * @return �������һ������,���и�����ʾӦ�ñ�����;�������null��ʾû�п������ĵ����
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
	 * ���ݵĵõ�ֵ ����һ��list,list��ÿ��ֵ�İ�λΪ������,ʮλ�͸�λΪ������
	 * ��ʽΪ(������)(������)
	 * ����709���������7������9
	 * @param i ��Ϊ���������,
	 * @param j ��Ϊ����������,
	 * @return һ��list,��ֳ�
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