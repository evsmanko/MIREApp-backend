package evgeny.manko.MIREApp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import evgeny.manko.MIREApp.MireAppApplication;
import evgeny.manko.MIREApp.model.Lesson;
import evgeny.manko.MIREApp.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleUpdateService {
    private final String scheduleResourceName = "/schedule.json";

    @Autowired
    private LessonRepository lessonRepository;

    public void updateFromJson(){
        try{
            File file = new File(MireAppApplication.class.getResource(scheduleResourceName).getFile());
            Map<String, List<Lesson>> groups = new ObjectMapper().readValue(file, new TypeReference<Map<String, List<Lesson>>>(){});
            for(Map.Entry<String, List<Lesson>> group : groups.entrySet()){
                String groupName = group.getKey();
                List<Lesson> lessons = group.getValue();
                for(Lesson lesson : lessons){
                    lesson.setStudyGroup(groupName);
                    lessonRepository.save(lesson);
                }
            }


        }
        catch (IOException ex){
            System.out.println(ex.toString());
        }
    }
}
