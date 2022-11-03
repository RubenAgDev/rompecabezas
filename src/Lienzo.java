package base;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Lienzo extends Canvas {
   private Modelo Mod = new Modelo();
   private InfoCuadro[][] Cuadrados;
   private InfoSeleccion Seleccion;

   public void paint(Graphics g) {
      this.PintarFondo(g);
      this.Seleccion = this.Mod.getSeleccion();
      this.Cuadrados = this.Mod.getCuadrados();

      for(int i = 0; i < this.Cuadrados.length; ++i) {
         for(int j = 0; j < this.Cuadrados[0].length; ++j) {
            if (!this.Cuadrados[i][j].getNumber().equals("0")) {
               this.PintarCuadro(g, this.Cuadrados[i][j].getX0(), this.Cuadrados[i][j].getY0(), this.Cuadrados[i][j].getNumber());
            }
         }
      }

      this.PintarSeleccion(g, this.Seleccion.getX0(), this.Seleccion.getY0());
   }

   protected void keyPressed(int Tecla) {
      int Accion = this.getGameAction(Tecla);
      switch(Accion) {
      case 1:
         this.Mod.MoverSeleccion(3);
         this.repaint(11, 19, 108, 108);
         break;
      case 2:
         this.Mod.MoverSeleccion(1);
         this.repaint(11, 19, 108, 108);
      case 3:
      case 4:
      case 7:
      default:
         break;
      case 5:
         this.Mod.MoverSeleccion(0);
         this.repaint(11, 19, 108, 108);
         break;
      case 6:
         this.Mod.MoverSeleccion(2);
         this.repaint(11, 19, 108, 108);
         break;
      case 8:
         this.Mod.MoverCuadro(this.Seleccion.getX0(), this.Seleccion.getY0());
         this.repaint(11, 19, 108, 108);
      }

   }

   private void PintarCuadro(Graphics g, int x0, int y0, String Number) {
      try {
         Image imgCuadrito = Image.createImage("/cuadrito.png");
         g.drawImage(imgCuadrito, x0, y0, 20);
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      g.setColor(0);
      g.setFont(Font.getFont(64, 1, 16));
      g.drawString(Number, x0 + 11, y0 + 17, 65);
   }

   private void PintarSeleccion(Graphics g, int x0, int y0) {
      try {
         Image imgSeleccion = Image.createImage("/seleccion.png");
         g.drawImage(imgSeleccion, x0, y0, 20);
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   private void PintarFondo(Graphics g) {
      try {
         Image imgFondo = Image.createImage("/fondo.png");
         g.drawImage(imgFondo, 0, 0, 20);
      } catch (Exception var4) {
         var4.printStackTrace();
         System.out.println("No se puede " + var4.getMessage());
      }

   }
}
