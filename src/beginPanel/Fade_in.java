package beginPanel;



import java.awt.*;

import java.awt.image.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

 

class FadeInFilter extends RGBImageFilter {

 

   int transparency;

 

   public FadeInFilter(int transparency)

     {

       canFilterIndexColorModel = true;

       this.transparency = transparency;

     }

 

   public int filterRGB(int x, int y, int rgb)

     {

       int pixcolor = rgb & 0x00FFFFFF;

       int a = (transparency << 24) &0xFF000000;

 

       return (a | pixcolor);

     }

 }

 

public class Fade_in extends JLabel implements Runnable {

 

   Image img1, img2, fg_img;

   Image offscreen;

 

   Thread anime = null;

 

   public void init()

     {

       img1 = (new ImageIcon((this.getClass().getResource("ль1ю╤.png"))) ).getImage();
 
       img2 = (new ImageIcon((this.getClass().getResource("ль1бл2.png")))).getImage();
 
       
       MediaTracker mt = new MediaTracker(this);

       mt.addImage (img1, 1);

       mt.addImage (img2, 1);

 

       try {

          mt.waitForAll();

         }

       catch (InterruptedException e) {};

 

       fg_img = img2;

     }

 

   public void update (Graphics g)

     {

       paint(g);

     }

 

   public void paint(Graphics g)

     {

       // prepare offscreen image

       Graphics goff = offscreen.getGraphics();

       goff.drawImage (img2, 0, 0, this);

       goff.drawImage (fg_img, 0, 0, this);

 

       // copy offscreen to onscreen

       g.drawImage (offscreen, 0, 0, this);

       goff.dispose();

     }

 

   public void run()

     {

       while (anime != null)

         {

           // fade In

           for (int i = 0; i < 256; i+= 32)

             {

               ImageFilter f = new FadeInFilter(i);
               System.out.println(img1==null);
               ImageProducer producer =
            		   
                  new FilteredImageSource(img1.getSource(), f);

 

               fg_img = createImage (producer);

 

                // wait until new image isready

                MediaTracker mt = new MediaTracker(this);

                mt.addImage (fg_img, 1);

 

                try {

                    mt.waitForID(1);

                  }

                catch (InterruptedException e){};

   

                repaint ();

 

                try {

                   Thread.sleep (500);

                  }

                catch (InterruptedException e){};

 

                fg_img.flush();

             }

 

           // fade Out

           for (int i = 255; i > 0; i -= 32)

             {

               ImageFilter f = new FadeInFilter(i);

               ImageProducer producer =

                  new FilteredImageSource(img1.getSource(), f);

 

               fg_img = createImage (producer);

 

               // wait until new image is ready

               MediaTracker mt = new MediaTracker(this);

               mt.addImage (fg_img, 1);

 

               try {

                  mt.waitForID(1);

                 }

               catch (InterruptedException e){};

 

               repaint();

 

               try {

                  Thread.sleep (500);

                 }

               catch (InterruptedException e){};

 

               fg_img.flush();

             }

         }

     }

 

   public void start()

     {

       if (anime == null)

         {

           anime = new Thread(this);

           anime.start();

         }

 

       offscreen = createImage (size().width,size().height);

     }

 }
