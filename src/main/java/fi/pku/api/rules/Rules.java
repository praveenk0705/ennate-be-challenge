package fi.pku.api.rules;

public class Rules {
    long baseWeight = 160;
    public String calculate(long weight){
        if (weight > (baseWeight+(.1*baseWeight)))
        return  "overweight";
        else if (weight < (baseWeight-(.1*baseWeight)))
        return  "underweight";
        else
            return "ok";

    }
}
