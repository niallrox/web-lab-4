package BusinessLayer.Entities.Data;

import java.io.Serializable;

public class DataDto implements Serializable {
    private Double x;
    private Double y;
    private Double r;
    public DataDto(){}

    public void setY(Double y) {
        this.y = y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Double getR() {
        return r;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }
}
