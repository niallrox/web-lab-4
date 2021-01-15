package BusinessLayer.Manager;

import BusinessLayer.Entities.Data;

import javax.ejb.Singleton;

@Singleton
public class Controller {

    public boolean checkXYR(double x, double y, double r) {
        //triangle
        if (x <= 0 && x >= -r && y <= 0 && y >= -r * 0.5 && y >= (-0.5 * x - 0.5 * r)) {
            return true;
        }
        //rectangle
        else if (x <= 0 && x >= -0.5 * r && y >= 0 && y <= r) {
            return true;
        }
        //ring
        else if (x >= 0 && y <= 0 && (x * x + y * y) <= r * r / 4) {
            return true;
        } else return false;
        //hate simplifies
    }
    public Data parseData(String x, String y, String z){
        double xData = Double.parseDouble(x);
        double yData = Double.parseDouble(y);
        double zData = Double.parseDouble(z);
        Data data = new Data(xData,yData,zData);
        data.setResult(checkXYR(xData,yData,zData));
        return data;
    }
}