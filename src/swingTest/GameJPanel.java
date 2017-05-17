package swingTest;



import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;




import elimGame2.BlockArgsData;
import elimGame2.BlockEnum;
import elimGame2.CommonGem;
import sun.swing.ImageCache;

public class GameJPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	public static int heightNum = 10;
	

	Thread t1 ;

	Thread t2 ;
	

	static	ImageIcon kuangIcon = new ImageIcon(JFrameTest.class.getResource("kuang.png"));
	 Image kuang=kuangIcon.getImage();
	public void paintComponent(Graphics g) {  
        super.paintComponent(g);  
      
       
		g.drawImage(kuang, 0, 0,this.getWidth(), this.getHeight(), this);  
    }  

	BlockArgsData blockArgsData;
	CommonGem[][] data;
	int height;
	int width;
	
	 
	 
	 
	public GameJPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		//绝对布局下设置位置和大小
		setBounds(100,200,400,500);
		setOpaque(false);
		
		height=10 ;
		width=8 ;
		blockArgsData = new BlockArgsData(height, width);
		blockArgsData.initializeData();
		data = blockArgsData.getArgs();
	
		
		
		
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				add(data[j][i].getLabel());
				
				
				
				data[j][i].getLabel().addMouseListener(new MouseListener() {
					
					
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						if(GameJPanel.lock){
							
							GameJPanel.this.mouseExchage(e.getComponent().getY()/50,e.getComponent().getX()/50);
							}
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				
						
					

				
				} );
			}
		}
		
		
		
	

		
		
		

	}
	
	
	static boolean lock =true;
	static int jb=-1;
	static int ib=-1;
	private void mouseExchage(int j,int i){
		
		if(jb==j&&ib==i){
			data[jb][ib].getLabel().setBorder(BorderFactory.createEmptyBorder());
			jb=-1;
			ib=-1;
			return;
		}
		
		
		
		
		if((i==ib&&(jb==j-1||jb==j+1))||(j==jb&&(ib==i-1||ib==i+1))){
			data[jb][ib].getLabel().setBorder(BorderFactory.createEmptyBorder());
			
			lock=false;
				  if(!exchage(j,i,jb,ib)){
					  data[jb][ib].getLabel().setBorder(BorderFactory.createEmptyBorder());
					  
					  
				  }
				  
			jb=-1;
			ib=-1;	  
			
		}else {
			System.out.println(jb+" "+ib);
			if(jb!=-1){
				data[jb][ib].getLabel().setBorder(BorderFactory.createEmptyBorder());
			}
			jb=	j;
			ib=	i;
			data[j][i].getLabel().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		}
		
		
			
		
		
		
		
		
		
		
		
		
		
	}
	  public boolean exchage(int j1,int i1,int j2,int i2){	
		  
		  new Thread(new Runnable() {//开辟一个工作线程
				@Override
				public void run() {
					t1 = new Thread(data[j1][i1].getLabel());
					t2 = new Thread(data[j2][i2].getLabel());
					data[j1][i1].getLabel().goThere(j2, i2);
					data[j2][i2].getLabel().goThere(j1, i1);
					t1.start();
					t2.start();
		
						
						
						
//						System.out.println("hello");
						if(blockArgsData.exchangeloc(j1, i1, j2, i2)){
							
							try {
								t1.join();
								t2.join();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
//							
//							List<CommonGem> listElim = blockArgsData.elim();					
//							List<CommonGem> listdrop =blockArgsData.drop();
//		
//
//							
//							System.out.println("消除数量"+listElim.size());
//							
//						
//							
//							GameJPanel.this.repaint();
//							
//							
//							for(CommonGem g :listdrop){
//								
//								
//								
//								if(g.getLabel().newGet){
//									GameJPanel.this.add(g.getLabel());
//									g.getLabel().newGet=false;
//								g.getLabel().addMouseListener(new MouseListener() {
//									
//									
//									
//									@Override
//									public void mouseReleased(MouseEvent e) {
//										// TODO Auto-generated method stub
//										
//									}
//									
//									@Override
//									public void mousePressed(MouseEvent e) {
//										// TODO Auto-generated method stub
//										
//									}
//									
//									@Override
//									public void mouseExited(MouseEvent e) {
//										// TODO Auto-generated method stub
//										
//									}
//									
//									@Override
//									public void mouseEntered(MouseEvent e) {
//										// TODO Auto-generated method stub
//										
//									}
//
//									@Override
//									public void mouseClicked(MouseEvent e) {
//										// TODO Auto-generated method stub
//										if(GameJPanel.lock){
//										GameJPanel.this.mouseExchage(e.getComponent().getY()/50,e.getComponent().getX()/50);
//										}
//									}
//									
//								
//										
//									
//
//								
//								});
//								}
//							}
//
//							try {
//								Thread.sleep(500);
//							} catch (InterruptedException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							
//							
//							for(CommonGem g :listElim){
//
//								
//								GameJPanel.this.remove(g.getLabel());
//							}
//							
//							
//							
//							
//							GameJPanel.this.repaint();
//							
//
//							ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(80);  
//							for(CommonGem g :listdrop){
//								
//								scheduledThreadPool.execute(new Thread(g.getLabel()));
//								 
//								
//							}
//							scheduledThreadPool.shutdown();
//							while(true){
//								if(scheduledThreadPool.isTerminated()){
//									
//									break;
//								}
//							
//								try {
//									Thread.sleep(10);
//								} catch (InterruptedException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//							}
//							
//							
////							
//
//							
//
//							
//							listElim.clear();
//							listdrop.clear();
//							
//
////							continue2Elim();
							continue2Elim();
							while(blockArgsData.isAbleElim()){
								continue2Elim();
							}
							
							jb=-1;
							ib=-1;
							lock=true;
							
							
							
							
						}else{

							try {
								t1.join();
								t2.join();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
//							System.out.println("hello");
							t1 = new Thread(data[j1][i1].getLabel());
							t2 = new Thread(data[j2][i2].getLabel());
							
							data[j1][i1].getLabel().goThere(j1, i1);
							data[j2][i2].getLabel().goThere(j2, i2);
							
							t1.start();
							t2.start();
							try {
								t1.join();
								t2.join();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							lock=true;
						}
						
				}
			}).start();

		  	
		  return true;
		 
		  
			
	  }
	  
	  

	public void continue2Elim(){
		
		
		{
			List<CommonGem> listElim ;					
			List<CommonGem> listdrop ;
			ScheduledExecutorService scheduledThreadPool;
			
			listElim = blockArgsData.elim();
			listdrop =blockArgsData.drop();
			scheduledThreadPool = Executors.newScheduledThreadPool(80);  
			
			
			

			for(CommonGem g :listdrop){
				
				
				if(g.getLabel().newGet&&g.getLabel().specialGem!=0){
					GameJPanel.this.add(g.getLabel());
					g.getLabel().newGet=false;
				g.getLabel().addMouseListener(new MouseListener() {
					
					
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						if(GameJPanel.lock){
							GameJPanel.this.mouseExchage(e.getComponent().getY()/50,e.getComponent().getX()/50);
							}
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				
						
					

				
				});
				}
				
				
			}
			
			
			
		
				
				for(CommonGem g :listElim){
					g.getLabel().commonElimSpecialEffects();
					
				
				}
				
				
				
				
			//等待动画结束??
			try {

				Thread.sleep(400);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//是的
			
			
			
			
			
//			GameJPanel.this.repaint();
			
			//加入新升级的方块和新产生的方块
			for(CommonGem g :listdrop){
				
				
				if(g.getLabel().newGet&&g.getLabel().specialGem==0){
					GameJPanel.this.add(g.getLabel());
			
					g.getLabel().newGet=false;
				g.getLabel().addMouseListener(new MouseListener() {
					
					
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						if(GameJPanel.lock){
							GameJPanel.this.mouseExchage(e.getComponent().getY()/50,e.getComponent().getX()/50);
							}
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				
						
					

				
				});
				}
				
				
			}
			//去除被消掉的方块
//			GameJPanel.this.repaint();
			
			for(CommonGem g :listElim){
				GameJPanel.this.remove(g.getLabel());
			
			}
			
			
			GameJPanel.this.repaint();
		
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//模拟掉落
				for(CommonGem g :listdrop){
					
					scheduledThreadPool.execute(new Thread(g.getLabel()));
					 
					
				}
				
//				GameJPanel.this.repaint();
				scheduledThreadPool.shutdown();
				
			while(true){
				if(scheduledThreadPool.isTerminated()){
					
					break;
				}
			
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
			GameJPanel.this.repaint();
			listElim.clear();
			listdrop.clear();

			}
	}
	
	public void actionPerformed(ActionEvent e) {
//		JLabelTest1.moveTO.x=100;
//		
//		
//		
//		  if (t1!=null&&!t1.isAlive()){
//			  
//		   t1.start();
//		  }  
		 }
	
	
	


}



