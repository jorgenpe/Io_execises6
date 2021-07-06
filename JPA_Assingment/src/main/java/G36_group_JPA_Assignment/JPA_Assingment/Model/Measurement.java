package G36_group_JPA_Assignment.JPA_Assingment.Model;

public enum Measurement {

    TBSP("tbsp"),
    TSP("tsp"),
    G("g"),
    HG("hg"),
    KG("kg"),
    ML("ml"),
    CL("cl"),
    DL("dl"),
    L("l");

    String measureTyp;

    Measurement(String measureType) {

        this.measureTyp =  measureType;
    }

    public String getMeasureTyp() {
        return measureTyp;
    }
}



