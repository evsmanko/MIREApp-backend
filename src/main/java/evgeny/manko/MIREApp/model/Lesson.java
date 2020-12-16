package evgeny.manko.MIREApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "lesson")
public class Lesson {

    @Transient
    public static final String SEQUENCE_NAME = "lessons_sequence";

    @Id
    @JsonIgnore
    private String id;
    private String name;
    private String studyGroup;
    private int[] weeks;
    private int dayOfWeek;
    private String room;
    private String type;
    private String teacher;
    private int num;

    public Lesson(String id, String name, String studyGroup, int[] weeks, int dayOfWeek, String room, String type, String teacher, int num) {
        this.id = id;
        this.name = name;
        this.studyGroup = studyGroup;
        this.weeks = weeks;
        this.dayOfWeek = dayOfWeek;
        this.room = room;
        this.type = type;
        this.teacher = teacher;
        this.num = num;
    }

    public Lesson() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(String studyGroup) {
        this.studyGroup = studyGroup;
    }

    public int[] getWeeks() {
        return weeks;
    }

    public void setWeeks(int[] weeks) {
        this.weeks = weeks;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }


}
