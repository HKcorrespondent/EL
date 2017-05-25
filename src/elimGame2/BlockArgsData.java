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
//		long startTime=System.nanoTime();   //��ȡ��ʼʱ��  //��¼����ʼʱ��
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
	//��������÷�
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
	 * ����ʱ�����������
	 * @param data
	 */
	public static void test(CommonGem[][] data){

//		data[1][4]=new CommonGem(BlockEnum.YELLOW, 4, 1);
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
//						System.out.print("���"+"    ");
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
				//��������г��ֲ�ɫ��ʯ
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
		//�����õ��²����ķ�������������ķ���
		private static List<CommonGem> changeList=new ArrayList<CommonGem>();
		/**
		 * �ڵ��øú���֮ǰ,Ӧ��ȷ���Ѿ�����������Ԫ�ر��,�ú������������б����Ԫ�ز�������䲻������������������null,��������Ԫ�ؽ�������
		 * @return ����һ��List������Ӧ�ñ������ķ���ĵ���,���Ұ�������Ϊ��Ч��ʯ�ķ������������
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
			
			//�����з�����������Ԫ�ش���
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
				
				//�ӷ�
				score+=argsData[j][i].getGemScore();
				
				//����Ԫ�ز��ӵ��嵥��
				argsData[j][i]=argsData[j][i].levelUp();
				if(argsData[j][i]!=null){
					changeList.add(argsData[j][i]);
					argsData[j][i].getLabel().newGet=true;
				}
			}
			//�����еı�һ��������Ԫ�ؼӵ�list��
			System.out.println("CommonElimSet="+CommonGem.getset().size());
			for(int t : CommonGem.getset()){
//				System.out.println(t);
				int j=t/100;
				int i=t%100;
				elimList.add(argsData[j][i]);
				
				//�ӷ�
				score+=argsData[j][i].getGemScore();
				
				//����Ԫ�ز��ӵ��嵥��
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
		 * ���亯��,���Ѿ�����������µ���,���ز����˵���ķ���.
		 * 
		 */	 
		 public List<CommonGem> drop(){
			 
			 
			 
			 //���������������һ�еı�������Ԫ������
			 
			 int[] fail = new int[width];
			
				//����

				
			 for(int i=0;i<width;i++){
				 for(int j=0;j<height;j++){
					 if(argsData[j][i]==null){
						 
						 fail[i]++;
						 //���ҵ���һ����������Ԫ��֮���Ϸ���Ԫ�ر��,��ζ�����ǽ������һ��
						 for(int jabove = j-1;jabove>=0;jabove--){
							 if(argsData[jabove][i]!=null){
								 argsData[jabove][i].needMove++;
							 }
						 }										 
					 }
				 }
			 }
			 
			//���������������ƶ�����,�ڳ�λ�ø��Ϸ��²�������
			 
			 for(int i=0;i<width;i++){
				 for(int j=height-1;j>=0;j--){
					 if(argsData[j][i]!=null&&argsData[j][i].needMove!=0){
						 changeList.add(argsData[j][i]);
						 int move =argsData[j][i].move();
						 
						 argsData[j+(move)][i]=argsData[j][i];
						 
						 //�µķ��鰴��Ӧ��������,���ǻ�û�п�������һ����ɫ�ķ�����Ч����ʱ�������Ч����
						 argsData[j+(move)][i].canLevelUp=true;
						 
						 argsData[j][i]=null;
						 
					 }
				 }
			 
			 }
			 
			 
			
			
			 //�����Ϸ������µķ���
			 for(int i=0;i<width;i++){
				 int move =fail[i];
				 
				 for(int j=height-1;j>=0;j--){
					 if(argsData[j][i]==null){
						 System.out.println(j+" "+i);
						 argsData[j][i]=new CommonGem(intTOcolor((int)(Math.random()*6+1)));
						 argsData[j][i].buildTopGem(i, j, move);

						 //�µķ��鰴��Ӧ��������,���ǻ�û�п�������һ����ɫ�ķ�����Ч����ʱ�������Ч����
						 argsData[j][i].canLevelUp=true;
						 
						 argsData[j][i].getLabel().newGet=true;
						 changeList.add(argsData[j][i]);
						 
					 }
					 
					 
					 
				 }
			}
			 
			 
			
			 
			 
			 
			 
			 
			 deleteOneMoreLevelUP();
			 
			
			 return changeList;
		 }
		 
		 
		 //��һ������������ˢ����������
		 public void cleanChangelist(){
			 changeList.clear();
			 
			 
			 
			 
		 }
		 
		 /**
		  * �������bug //�µķ��鰴��Ӧ��������,���ǻ�û�п�������һ����ɫ�ķ�����Ч����ʱ�������Ч����
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
		 
		 
		 
		 
		 
		 
		//��һ������������ˢ����������
		 public void cleanLevelUp(){
			
			 for(int j =0;j<height;j++){
				 for(int i=0;i<width;i++){
					 if(argsData[j][i]!=null)
					 argsData[j][i].canLevelUp=false; 
				 }
			 }
			 
			 
			 
		 }
		 

		
}
