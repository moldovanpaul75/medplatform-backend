package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.ActivityDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.Activity;
import ro.tuc.ds2020.repositories.ActivityRepository;


@Component
public class ActivityService extends Service<ActivityDTO, Activity> implements IActivityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IActivityService.class);

    @Autowired
    protected ActivityService(ActivityRepository repository, IMapper<ActivityDTO, Activity> mapper) {
        super(repository, mapper);
    }



}
