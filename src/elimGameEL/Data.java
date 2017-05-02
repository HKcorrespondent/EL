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
	
	//�������Ե�main����
	//######################################
	public static void main(String[] args) {
		long startTime=System.nanoTime();   //��ȡ��ʼʱ��  //��¼����ʼʱ��
		
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
		long endTime=System.nanoTime(); //��ȡ����ʱ�� //��¼�������ʱ��
		System.out.println();
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)/1000000D+"ms"); 
	}
	//#######################################
	
	//****************************************
	private final int height ;
	private final int width ;
	private int[][] argsData ;
	private final int  variety;
	//****************************************
	/**
	 * ��������Ľṹ���
	 * @param h Ϊ����ĸ߶�(����)
	 * @param w Ϊ����Ŀ��(����)
	 * @param variety ������ͼ��������
	 */
	Data(int h,int w,int variety){
		height = h;
		width = w;
		argsData = new int[height][width];
		this.variety=variety;
		
	}
	

	
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
	 * �жϵ�ǰ�����Ƿ��п����������,���û�оͷ���null,���򷵻�һ������,���и�����ʾӦ�ñ�������Ԫ��
	 * ��������ʱ���Ա������鵥����Ը������д���
	 * @return �������ԭ�����һ����������,���и�����ʾӦ�ñ�����;�������null��ʾû�п������ĵ����
	 * 
	 */
	public int[][] isAbleElim(){
		int[][] argsData = new int[height][width];
		boolean ableElim = false;
		//���滻system.arrayCopy����
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				argsData[j][i]=this.argsData[j][i];
			}
		}
		//�����������е�ÿ��Ԫ�ؼ������ΧԪ��,���һ������ͬ�ͷ���
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				
				//�Ⱥ�����
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
					
					//������������������
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
				
				//������
				
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
					
					//����������������
					
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
	 * ���ݵĵõ�ֵ ����һ��list,list��ÿ��ֵ�İ�λΪ������,ʮλ�͸�λΪ������
	 * ��ʽΪ(������)(������)
	 * ����709���������7������9
	 * @param i ��Ϊ���������,
	 * @param j ��Ϊ����������,
	 * @param k ��ji�ľ���
	 * @return һ��list,��ֳ�
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
	 * �жϵ�ǰ�����Ƿ�Ϊ��ͼ
	  
	 * @return true��ʾ��ͼ,false��ʾ������ͼ
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
	 * ������Ҳ�������������ʯ��λ�ò��жϽ������Ƿ�������������������drop�������������ͱ�ʯ����
	  
	 * @return null��ʾ��Ҳ����󲻿�������ʧ�ܣ���ֵlist���ڶ�������
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
	 * �������󣬽����п���λ�������Ϸ���λ���������������Ϸ��ڳ���λ�����µ������ʯ���
	  
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