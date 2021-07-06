package service.ifc;

import entity.Point;

public interface PointService {
    Point createPoint(Point point, String userId);
    Point getPointById(Long id);
}
