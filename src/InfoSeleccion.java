package base;

public class InfoSeleccion {
   private int x0;
   private int y0;

   public InfoSeleccion(int x, int y) {
      this.x0 = x;
      this.y0 = y;
   }

   public void Mover(int dx, int dy) {
      this.x0 += dx;
      this.y0 += dy;
      if (this.x0 < 11) {
         this.x0 = 11;
      } else if (this.x0 > 89) {
         this.x0 = 89;
      }

      if (this.y0 < 19) {
         this.y0 = 19;
      } else if (this.y0 > 97) {
         this.y0 = 97;
      }

   }

   public int getX0() {
      return this.x0;
   }

   public int getY0() {
      return this.y0;
   }
}
