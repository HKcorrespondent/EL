package elimGame2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;





public class BlockArgsData {
	public static void main(String[] args) {
		long startTime=System.nanoTime();   //��ȡ��ʼʱ��  //��¼����ʼʱ��
		System.out.println((int)(Math.random()*6+1));
		
		BlockArgsData data = new BlockArgsData(8, 6);
		data.initializeData();
		data.showData(data.argsData);
		System.out.println();
		data.isAbleElim();
		data.showData(data.argsData);
		System.out.println("isDead: "+data.isDead());
		
		int i=0;
		while(i<10){
			Scanner in =new Scanner(System.in);
			System.out.println(
			data.exchangeloc(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
			System.out.println(data.elim().size());
			data.showData(data.argsData);
		}
		
		
		long endTime=System.nanoTime(); //��ȡ����ʱ�� //��¼�������ʱ��
		System.out.println();
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)/1000000D+"ms"); 
	}
	
	
	
	
	private CommonGem[][] argsData ;
	private final int height ;
	private final int width ;
	
	
	public BlockArgsData(int h,int w){
		height = h;
		width = w;
		argsData = new CommonGem[height][width];
		
		
	}
	public CommonGem[][] getArgs(){
		return argsData;
		
	}
	
	
	
	
	
	//***************************************
		/**
		 * �������Ե�ʱ����ʾ�����
		 */
		public void showData(CommonGem[][] data){
			if(data!=null){
				System.out.println("##  0   1   2   3   4   5   6    7 ");
				for(int j =0;j<height;j++){
					System.out.print(j+"  ");
					for(int i =0;i<width;i++){
						if(argsData[j][i]==null){
							System.out.print("���"+"    ");
							
							continue;
						}
						if(argsData[j][i].isElim){
						System.out.print("���"+"    ");
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
		 * ��ʼ������,���Ҹ�ÿ��λ�����ϱ�ʯ
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
							argsData[j][i]=new CommonGem(intTOcolor((int)(Math.random()*6+1)), i, j);
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
		 * �жϵ�ǰ�����Ƿ��п����������,���û�оͷ���false,���򷵻�true,����Ӧ�ñ�������Ԫ�ص�iselim��Ϊtrue
		 * 
		 * @return true����false
		 * 
		 */
		public boolean isAbleElim(){
			
			boolean ableElim = false;
			//���滻system.arrayCopy����
		
			//�����������е�ÿ��Ԫ�ؼ������ΧԪ��,���һ������ͬ�ͷ���
			for(int i =0;i<width;i++){
				for(int j =0;j<height;j++){
					
					//�Ⱥ�����
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
						
						//����������������������
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
					
					//������
					
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
						
						//����������������
						
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
		 * �жϵ�ǰ�����Ƿ�Ϊ��ͼ
		  
		 * @return true��ʾ��ͼ,false��ʾ������ͼ
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
		 * ������Ҳ�������������ʯ��λ�ò��жϽ������Ƿ������������isAbleElim����.�����������,���鲻��,���������,�����ѷ�������,������������Ԫ�ص�isElim���Ϊtrue;
		  
		 * @return true ��ʾ���ڵ�����������ѽ������Բ������� ,false��ʾ��������,���鷵��ԭ��
		 */
		
		public boolean exchangeloc(int j1,int i1,int j2,int i2){
			CommonGem gem1=checkArge(j1, i1);
			CommonGem gem2=checkArge(j2, i2);
			if(gem1!=null&&gem2!=null){
				argsData[j2][i2]=gem1;
				argsData[j1][i1]=gem2;
				if(isAbleElim()){
					
					if(argsData[j2][i2].isElim==true){
						argsData[j2][i2].canLevelUp=true;
					}
					if(argsData[j1][i1].isElim==true){
						argsData[j1][i1].canLevelUp=true;
					}
					
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
		/**
		 * �ڵ��øú���֮ǰ,Ӧ��ȷ���Ѿ�����������Ԫ�ر��
		 * @return ����һ��List������Ӧ�ñ������ķ���ĵ���,���Ұ�������Ϊ��Ч��ʯ�ķ������������
		 */	 
		
		public List<CommonGem> elim(){
			List<CommonGem> list=new ArrayList<CommonGem>();
			for(int i =0;i<width;i++){
				for(int j =0;j<height;j++){
					if(argsData[j][i].isElim){
						list.add(argsData[j][i]);
						argsData[j][i]=argsData[j][i].elim();
					}
				}
			}
			
			return list;
		}
		
		/**
		 * ���亯��,���Ѿ�����������µ���
		 * 
		 */	 
		
}
