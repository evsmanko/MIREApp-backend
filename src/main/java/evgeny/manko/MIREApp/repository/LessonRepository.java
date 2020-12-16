package evgeny.manko.MIREApp.repository;

import evgeny.manko.MIREApp.model.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends MongoRepository<Lesson, Integer> {

    List<Lesson> findAllByStudyGroup(String studyGroup);
    List<Lesson> findAllByStudyGroupAndWeeksContains(String studyGroup, int[] weeks);
    List<Lesson> findAllByStudyGroupAndWeeksContainsAndDayOfWeek(String studyGroup, int[] weeks, int dayOfWeek);

}
