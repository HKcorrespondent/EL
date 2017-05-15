package swingTest;



import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.sun.prism.Image;

import elimGame2.BlockArgsData;
import elimGame2.BlockEnum;
import elimGame2.CommonGem;

public class GameJPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	public static int heightNum = 10;
	

	Thread t1 ;

	Thread t2 ;
	
	java.awt.Image	backGroundImage = new ImageIcon ("C:\\Users\\asus\\Desktop\\sucai\\big.jpg").getImage();
	
	BlockArgsData blockArgsData;
	CommonGem[][] data;
	int height;
	int width;
	
	public GameJPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		//绝对布局下设置位置和大小
		setBounds(20,20,400,600);
		
		height=10 ;
		width=8 ;
		blockArgsData = new BlockArgsData(height, width);
		blockArgsData.initializeData();
		data = blockArgsData.getArgs();
	
		
		
		
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				add(data[j][i].getLabel());
				final int  jy = j;
				final int  ix = i;
				
				
				data[j][i].getLabel().addMouseListener(new MouseListener() {
					
					
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
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
						if(GameJPanel.lock){
							System.out.println(e.getComponent().getY()/50+"  "+e.getComponent().getX()/50);
						GameJPanel.this.mouseExchage(e.getComponent().getY()/50,e.getComponent().getX()/50);
						}
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
		
		
		
		
		if(j==jb&&(ib==i-1||ib==i+1)){
			lock=false;
				  	exchage(j,i,jb,ib);
				  
				  
			
		}else if(i==ib&&(jb==j-1||jb==j+1)){
			lock=false;
					exchage(j,i,jb,ib);
				
				
				
		}else {
			if(jb!=-1){
			data[jb][ib].getLabel().setBorder(BorderFactory.createEmptyBorder());}
			jb=	j;
			ib=	i;
			data[j][i].getLabel().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		}
		
		
			
		
		
		
		
		
		
		
		
		
		
	}
	  public void exchage(int j1,int i1,int j2,int i2){	
		  
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
							
							List<CommonGem> elimList = blockArgsData.elim();
						
							
							
							
							
							List<CommonGem> listdrop =blockArgsData.drop();
		
							
							
							
							System.out.println("消除数量"+elimList.size());
							
						
							
							GameJPanel.this.repaint();
							
							for(CommonGem g :listdrop){
								
								
								if(g.getLabel().newGet){
									GameJPanel.this.add(g.getLabel());
									g.getLabel().newGet=false;
								g.getLabel().addMouseListener(new MouseListener() {
									
									
									
									@Override
									public void mouseReleased(MouseEvent e) {
										// TODO Auto-generated method stub
										
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
										if(GameJPanel.lock){
											
											
								
										GameJPanel.this.mouseExchage(e.getComponent().getY()/50,e.getComponent().getX()/50);
										}
									}
									
								
										
									

								
								});
								}
							}
							for(CommonGem g :elimList){
								GameJPanel.this.remove(g.getLabel());
							}
							GameJPanel.this.repaint();
							
							System.out.println("掉落的数量"+listdrop.size());
							ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(80);  
							for(CommonGem g :listdrop){
								
								scheduledThreadPool.execute(new Thread(g.getLabel()));
								 
								
							}
							scheduledThreadPool.shutdown();
							while(true){
								if(scheduledThreadPool.isTerminated()){
									
									break;
								}
							
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
							
//							
							
							GameJPanel.this.repaint();
							
							
							jb=-1;
							ib=-1;
							lock=true;
							
							blockArgsData.showData(data);
//							blockArgsData.cleanChangelist();
							
							
							
//							GameJPanel.this.removeAll();
//							for(int i =0;i<width;i++){
//								for(int j =0;j<height;j++){
//									add(data[j][i].getLabel());
//							
//								}
//							}
//							GameJPanel.this.repaint();
//							System.out.println("OK");
							
							

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

		  	jb=-1;
			ib=-1;
		  
		  System.out.println(ib+"  "+jb);
		  
			
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



