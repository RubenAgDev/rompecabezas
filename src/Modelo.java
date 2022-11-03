package base;

import java.util.Random;

public class Modelo {
   private InfoCuadro[][] Cuadrados = new InfoCuadro[4][4];
   private InfoSeleccion Seleccion = new InfoSeleccion(11, 19);
   private int[] LosNumeros = new int[16];

   public Modelo() {
      this.GenerarNumeros();
      this.CrearCuadros();
   }

   public void GenerarNumeros() {
      Random r = new Random();
      int n = r.nextInt(16);
      this.LosNumeros[0] = n;

      for(int i = 1; i < this.LosNumeros.length; ++i) {
         do {
            n = r.nextInt(16);
         } while(this.YaExiste(n, i));

         this.LosNumeros[i] = n;
      }

   }

   public boolean YaExiste(int n, int j) {
      for(int i = 0; i < j; ++i) {
         if (this.LosNumeros[i] == n) {
            return true;
         }
      }

      return false;
   }

   private void CrearCuadros() {
      this.Cuadrados[0][0] = new InfoCuadro(14, 22, String.valueOf(this.LosNumeros[0]));
      this.Cuadrados[0][1] = new InfoCuadro(40, 22, String.valueOf(this.LosNumeros[1]));
      this.Cuadrados[0][2] = new InfoCuadro(66, 22, String.valueOf(this.LosNumeros[2]));
      this.Cuadrados[0][3] = new InfoCuadro(92, 22, String.valueOf(this.LosNumeros[3]));
      this.Cuadrados[1][0] = new InfoCuadro(14, 48, String.valueOf(this.LosNumeros[4]));
      this.Cuadrados[1][1] = new InfoCuadro(40, 48, String.valueOf(this.LosNumeros[5]));
      this.Cuadrados[1][2] = new InfoCuadro(66, 48, String.valueOf(this.LosNumeros[6]));
      this.Cuadrados[1][3] = new InfoCuadro(92, 48, String.valueOf(this.LosNumeros[7]));
      this.Cuadrados[2][0] = new InfoCuadro(14, 74, String.valueOf(this.LosNumeros[8]));
      this.Cuadrados[2][1] = new InfoCuadro(40, 74, String.valueOf(this.LosNumeros[9]));
      this.Cuadrados[2][2] = new InfoCuadro(66, 74, String.valueOf(this.LosNumeros[10]));
      this.Cuadrados[2][3] = new InfoCuadro(92, 74, String.valueOf(this.LosNumeros[11]));
      this.Cuadrados[3][0] = new InfoCuadro(14, 100, String.valueOf(this.LosNumeros[12]));
      this.Cuadrados[3][1] = new InfoCuadro(40, 100, String.valueOf(this.LosNumeros[13]));
      this.Cuadrados[3][2] = new InfoCuadro(66, 100, String.valueOf(this.LosNumeros[14]));
      this.Cuadrados[3][3] = new InfoCuadro(92, 100, String.valueOf(this.LosNumeros[15]));
   }

   public InfoCuadro[][] getCuadrados() {
      return this.Cuadrados;
   }

   public InfoSeleccion getSeleccion() {
      return this.Seleccion;
   }

   public void MoverSeleccion(int Movimiento) {
      switch(Movimiento) {
      case 0:
         this.Seleccion.Mover(26, 0);
         break;
      case 1:
         this.Seleccion.Mover(-26, 0);
         break;
      case 2:
         this.Seleccion.Mover(0, 26);
         break;
      case 3:
         this.Seleccion.Mover(0, -26);
      }

   }

   public void MoverCuadro(int x0Sel, int y0Sel) {
      for(int i = 0; i < this.Cuadrados.length; ++i) {
         for(int j = 0; j < this.Cuadrados[0].length; ++j) {
            if (this.Cuadrados[i][j].isSelected(x0Sel, y0Sel) && !this.Cuadrados[i][j].getNumber().equals("0")) {
               String Auxiliar;
               if (j < 3 && this.Cuadrados[i][j + 1].getNumber().equals("0")) {
                  Auxiliar = this.Cuadrados[i][j].getNumber();
                  this.Cuadrados[i][j].Numero = this.Cuadrados[i][j + 1].getNumber();
                  this.Cuadrados[i][j + 1].Numero = Auxiliar;
                  return;
               }

               if (j > 0 && this.Cuadrados[i][j - 1].getNumber().equals("0")) {
                  Auxiliar = this.Cuadrados[i][j].getNumber();
                  this.Cuadrados[i][j].Numero = this.Cuadrados[i][j - 1].getNumber();
                  this.Cuadrados[i][j - 1].Numero = Auxiliar;
                  return;
               }

               if (i < 3 && this.Cuadrados[i + 1][j].getNumber().equals("0")) {
                  Auxiliar = this.Cuadrados[i][j].getNumber();
                  this.Cuadrados[i][j].Numero = this.Cuadrados[i + 1][j].getNumber();
                  this.Cuadrados[i + 1][j].Numero = Auxiliar;
                  return;
               }

               if (i > 0 && this.Cuadrados[i - 1][j].getNumber().equals("0")) {
                  Auxiliar = this.Cuadrados[i][j].getNumber();
                  this.Cuadrados[i][j].Numero = this.Cuadrados[i - 1][j].getNumber();
                  this.Cuadrados[i - 1][j].Numero = Auxiliar;
                  return;
               }

               return;
            }
         }
      }

   }
}
