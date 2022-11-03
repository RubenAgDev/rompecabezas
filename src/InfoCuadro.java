package base;

public class InfoCuadro {
   public String Numero;
   private int x0;
   private int y0;

   public InfoCuadro(int x, int y, String N) {
      this.x0 = x;
      this.y0 = y;
      this.Numero = N;
   }

   public boolean isSelected(int x0Seleccion, int y0Seleccion) {
      return x0Seleccion + 3 == this.x0 && y0Seleccion + 3 == this.y0;
   }

   public int getX0() {
      return this.x0;
   }

   public int getY0() {
      return this.y0;
   }

   public String getNumber() {
      return this.Numero;
   }
}
