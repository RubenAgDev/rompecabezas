package base;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

public class JuegoRompecabezas extends MIDlet implements CommandListener {
   private Lienzo Escenario;
   private Display display;
   private Command ExitCmd;

   public void startApp() {
      this.display = Display.getDisplay(this);
      this.display.setCurrent(this.getEscenario());
   }

   public void pauseApp() {
   }

   public void destroyApp(boolean unconditional) {
      this.notifyDestroyed();
   }

   public void commandAction(Command command, Displayable displayable) {
      if (displayable == this.Escenario && command == this.ExitCmd) {
         this.destroyApp(true);
      }

   }

   private Lienzo getEscenario() {
      if (this.Escenario == null) {
         this.Escenario = new Lienzo();
         this.Escenario.addCommand(this.getExitCmd());
         this.Escenario.setCommandListener(this);
      }

      return this.Escenario;
   }

   private Command getExitCmd() {
      if (this.ExitCmd == null) {
         this.ExitCmd = new Command("Exit", 7, 0);
      }

      return this.ExitCmd;
   }
}
