package service.impl;

import entity.Point;
import entity.User;
import exception.ArgumentNotValidException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.PointRepository;
import repository.UserRepository;
import service.ifc.PointService;
import validation.ifc.Validator;

@Service
@RequiredArgsConstructor
public class PointServiceImpl implements PointService {
    private final PointRepository pointRepository;
    private final Validator<Point> validator;

    public Point createPoint(Point point, String userId) {
        Point validate = validator.validate(point);
        validate.setUserId(userId);
        pointRepository.save(validate);
        return validate;
    }

    public Point getPointById(Long id) {
        return pointRepository.getById(id);
    }
}
