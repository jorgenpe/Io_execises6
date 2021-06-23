package Sequencer;

public class User_Sequencer {

    private int idSequence;

    User_Sequencer(){
        this.idSequence = 0;
    }

    public int hasNext(){

        return idSequence++;
    }

    public void reset(){

        idSequence = 0;
    }

}
