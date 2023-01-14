package model;

/***
 * @author 22046-NelsonEscalante
 */
public class Radio implements IRadio{
    
    private String status;
    private String band;
    private int AMStation;
    private double FMStation;
    private int[] AMSlots;
    private double[] FMSlots;


    public Radio(String status, String band, int AMStation, double FMStation, int[] AMSlots, double[] FMSlots){
        this.status = status;
        this.band = band;
        this.AMStation = AMStation;
        this.FMStation = FMStation;
        this.AMSlots = AMSlots;
        this.FMSlots = FMSlots;
    }

    @Override
    public void on(){
        this.status = "ON";
    }

    @Override
    public void off(){
        this.status = "OFF";
    }

    @Override
    public boolean isOn(){
        if (this.status == "ON"){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void setFrequence(String freq) throws Exception{
        if (!(freq == "AM") || !(freq == "FM")){
            throw new Exception();
        } else {
            this.band = freq;
        }
    }

    @Override
    public String getFrequence(){
        return this.band;
    }

    @Override
    public void Forward(){
        if (this.band == "AM"){
            this.AMStation += 10;
            if (this.AMStation > 1610){
                this.AMStation = 530;
            }
        } else {
            this.FMStation += 0.2;
            if (this.FMStation > 107.9){
                this.FMStation = 87.9;
            }
        }
    }

    @Override
    public void Backward(){
        if (this.band == "AM"){
            this.AMStation -= 10;
            if (this.AMStation < 530){
                this.AMStation = 1610;
            }
        } else {
            this.FMStation -= 0.2;
            if (this.FMStation < 87.9){
                this.FMStation = 107.9;
            }
        }
    }

    @Override
    public double getFMActualStation(){
        return this.FMStation;
    }

    @Override
    public int getAMActualStation(){
        return this.AMStation;
    }

    @Override
    public void setFMActualStation(double station){
        this.FMStation = station;
    }

    @Override
    public void setAMActualStation(int station){
        this.AMStation = station;
    }

    @Override
    public void saveFMStation(double station, int slot){
        this.FMSlots[slot] = station;
    }

    @Override
    public void saveAMStation(int station, int slot){
        this.AMSlots[slot] = station;
    }

    @Override
    public double getFMSlot(int slot){
        return this.FMSlots[slot];
    }

    @Override
    public int getAMSlot(int slot){
        return this.AMSlots[slot];
    }
}
