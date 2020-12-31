package AENSIMLH.TP5.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {

    float[] xEtY = new float[2];

    public float[] getxEtY() {
        return xEtY;
    }

    public void setxEtY(float[] xEtY) {
        this.xEtY = xEtY;
    }

    public void setX(float i){
        this.xEtY[1] = i;
    }
    public void setY(float i){
        this.xEtY[0] = i;
    }


    public float getX(){
        return xEtY[1];
    }
    public float getY(){
        return xEtY[0];
    }


    public Coordinates(){    }

    public String toString(){

        String re = "" + xEtY[1]+ " " + xEtY[0];
        return re;
    }


}
