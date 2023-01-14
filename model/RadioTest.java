package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadioTest {
    
    int[] AMSlots = {530, 530, 530, 530, 530, 530, 530, 530, 530, 530, 530, 530};
    double[] FMSlots = {87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9, 87.9};

    IRadio myRadio = new Radio("OFF", "AM", 530, 87.9, AMSlots, FMSlots);


    @Test
    void TC1_AMUpperCicle() {
        myRadio.setAMActualStation(1610);
        myRadio.Forward();
        int result = myRadio.getAMActualStation();
        assertEquals(530, result);
    }

    @Test
    void TC2_AMLowerCicle() {
        myRadio.setAMActualStation(530);
        myRadio.Backward();
        int result = myRadio.getAMActualStation();
        assertEquals(1610, result);
    }

    @Test
    void TC3_ChangeBand() {
        boolean flag;

        try {
            myRadio.setFrequence("FM");
            flag = true;
        } catch(Exception e) {
            flag = false;
        }

        assertTrue(flag);
    }
}
