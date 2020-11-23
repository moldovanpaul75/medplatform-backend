package ro.tuc.ds2020.services;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.ActivityDTO;
import ro.tuc.ds2020.dtos.builders.IMapper;
import ro.tuc.ds2020.entities.Activity;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    protected final ActivityService activityService;
    protected final IMapper<ActivityDTO, Activity> mapper;

    @Autowired
    public Consumer(ActivityService activityService, IMapper<ActivityDTO, Activity> mapper) {
        this.activityService = activityService;
        this.mapper = mapper;
    }


    private boolean checkRules(ActivityDTO activity){
        long timeSpent = activity.getEnd() - activity.getStart();
        String name = activity.getActivity();

        if(activity.getActivity().equals("Sleeping") && timeSpent >= 25200000) return true;
        else if(name.equals("Leaving") && timeSpent >= 18000000) return true;
            else if((name.equals("Toileting") || name.equals("Showering") || name.equals("Grooming")) && timeSpent >= 1800000) return true;

        return false;
    }


    @RabbitListener(queues = "spring-boot")
    public void messageReceiver(String message) {
        Gson gson = new Gson();
        ActivityDTO activityDTO = gson.fromJson(message, ActivityDTO.class);
        activityDTO.setFlag(this.checkRules(activityDTO));
        System.out.println(activityDTO);

        activityService.save(activityDTO);
    }

}
