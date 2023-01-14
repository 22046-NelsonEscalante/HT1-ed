package view;

import java.util.Scanner;
import model.IRadio;

/***
 * @author 22046-NelsonEscalante
 */
public class DriverProgram {
    
    public static void main(String[] args) {
        IRadio myRadio;
        Scanner in = new Scanner(System.in);

        in.close();
    }

    public static void displayMenu(Scanner in, IRadio radio){
        int choice;
        
        System.out.println("1. Botón de encendido/apagado.");
        System.out.println("2. Cambiar de banda.");
        System.out.println("3. Aumentar frecuencia.");
        System.out.println("4. Disminuir frecuencia.");
        System.out.println("5. Guardar frecuencia.");
        System.out.println("6. Abrir guardados.");
        System.out.println("7. Cerrar programa.");
        System.out.println("Escoja la opción que desea realizar.");
        choice = Integer.parseInt(in.nextLine());

        switch (choice) {
            case 1:
                powerButton(radio);
                break;
            case 2:
                changeBand(radio);
                break;
            case 3:
                tuneUp(in, radio);
                break;
            case 4:
                tuneDown(in, radio);
                break;
            case 5:
            case 6:
            case 7:
            default:
                System.out.println("Por favor, ingrese un valor entre 1 y 7.");
                break;     
        }
    }

    public static void powerButton(IRadio radio){
        if (radio.isOn()){
            radio.off();
        } else {
            radio.on();
        }
    }

    public static void changeBand(IRadio radio){
        if (radio.getFrequence() == "AM"){
            try {
                radio.setFrequence("FM");
            } catch(Exception e) {
                System.out.println("Error! banda inválida. (Este error no debería de verse.)");
            }
        } else {
            try {
                radio.setFrequence("AM");
            } catch(Exception e) {
                System.out.println("Error! banda inválida. (Este error no debería de verse.)");
            }
        }
    }

    public static void tuneUp(Scanner in, IRadio radio){
        System.out.println("Ingrese un múltiplo para aumentar la frecuencia");
        System.out.println("(Nota: La frecuencia AM aumenta de a 10, y la FM de a 0.2)");
        int choice = Integer.parseInt(in.nextLine());

        for (int i = 0; i < choice; i++){
            radio.Forward();
        }
    }

    public static void tuneDown(Scanner in, IRadio radio){
        System.out.println("Ingrese un múltiplo para disminuir la frecuencia");
        System.out.println("(Nota: La frecuencia AM disminuye de a 10, y la FM de a 0.2)");
        int choice = Integer.parseInt(in.nextLine());

        for (int i = 0; i < choice; i++){
            radio.Backward();
        }
    }
}
