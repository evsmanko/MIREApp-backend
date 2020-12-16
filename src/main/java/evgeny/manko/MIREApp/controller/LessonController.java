package evgeny.manko.MIREApp.controller;

import evgeny.manko.MIREApp.model.Lesson;
import evgeny.manko.MIREApp.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController{

    @Autowired
    private LessonRepository lessonRepository;

    @RequestMapping("/getByGroupName")
    public List<Lesson> getLessonsByGroup(@RequestParam String groupName, @RequestParam(required = false) Integer week, @RequestParam(required = false)  Integer dayOfWeek){
        if(dayOfWeek == null && week == null){
            return lessonRepository.findAllByStudyGroup(groupName);
        }
        else{
            if(dayOfWeek == null){
                return lessonRepository.findAllByStudyGroupAndWeeksContains(groupName, new int[]{week});
            }
            else{
                return lessonRepository.findAllByStudyGroupAndWeeksContainsAndDayOfWeek(groupName, new int[]{week}, dayOfWeek);
            }
        }
    }
}
