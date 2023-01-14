package view;

import java.util.Scanner;
import model.IRadio;
import model.Radio;

/***
 * @author 22046-NelsonEscalante
 */
public class DriverProgram {
    
    public static void main(String[] args) {
        IRadio myRadio;
        Scanner in = new Scanner(System.in);

        int[] AMSlots = {530, 530, 530, 530, 530, 530, 530, 530, 530, 530, 530, 530};
        double[] FMSlots = {87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9};

        myRadio = new Radio("OFF", "AM", 530, 87.9, AMSlots, FMSlots);

        while (true) {
            displayMenu(in, myRadio);
        }
    }

    public static void displayMenu(Scanner in, IRadio radio){
        int choice;
        String status;

        if (radio.isOn()) {
            status = "ON";
        } else {
            status = "OFF";
        }
        
        System.out.println("**********************************************");
        System.out.println("Estado de la radio: " + status);
        System.out.println("Banda: " + radio.getFrequence());

        if (radio.getFrequence() == "AM") {
            System.out.println("Emisora: " + Integer.toString(radio.getAMActualStation()));
        } else {
            System.out.println("Emisora: " + Double.toString(radio.getFMActualStation()));
        }

        System.out.println("----------------------------------------------");
        System.out.println("1. Botón de encendido/apagado.");
        System.out.println("2. Cambiar de banda.");
        System.out.println("3. Aumentar frecuencia.");
        System.out.println("4. Disminuir frecuencia.");
        System.out.println("5. Guardar frecuencia.");
        System.out.println("6. Abrir guardados.");
        System.out.println("7. Cerrar programa.");
        System.out.println("Escoja la opción que desea realizar.");
        System.out.println("**********************************************");
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
                saveFreq(in, radio);
            case 6:
            case 7:
                System.exit(0);
                break;
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

    public static void saveFreq(Scanner in, IRadio radio){
        System.out.println("Ingrese un número del 1 al 12. La frecuencia actual se guardará en el espacio asignado.");
        int slot = Integer.parseInt(in.nextLine());

        if ((slot < 1) || (slot > 12)){
            System.out.println("Por favor, ingrese un valor entre 1 y 12.");
        } else {
            if (radio.getFrequence() == "AM") {
                radio.saveAMStation(radio.getAMActualStation(), slot);
            } else {
                radio.saveFMStation(radio.getFMActualStation(), slot);
            }
        }
    }

    public static void selectSave(Scanner in, IRadio radio){
        System.out.println("Ingrese un número entre 1 y 12 para seleccionar la frecuencia guardada.");
        int slot = Integer.parseInt(in.nextLine());

        if ((slot < 1) || (slot > 12)){
            System.out.println("Por favor, ingrese un valor entre 1 y 12.");
        } else {
            if (radio.getFrequence() == "AM") {
                radio.setAMActualStation(radio.getAMSlot(slot));
            } else {
                radio.setFMActualStation(radio.getFMSlot(slot));
            }
        }
    }
}
