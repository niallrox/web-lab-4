package validation.impl;

import entity.Point;
import exception.ArgumentNotValidException;
import org.springframework.stereotype.Component;
import validation.ifc.Validator;

@Component
public class PointValidator implements Validator<Point> {

    public Point validate(Point point) {
        Double x = point.getX();
        Double y = point.getY();
        Double r = point.getR();

        if (r <= 0){ throw new ArgumentNotValidException("radius can't be negative or zero"); }

        boolean checkInArea = checkInArea(x, y, r);
        point.setResult(checkInArea);
        return point;
    }

    private boolean checkInArea(Double x, Double y, Double r) {
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
}
