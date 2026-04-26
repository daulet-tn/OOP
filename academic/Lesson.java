package academic;

import enums.LessonType;
import users.Teacher;

public class Lesson {
    private String lessonId;
    private LessonType type;
    private String topic;
    private Teacher teacher;

    public Lesson(String lessonId, LessonType type, String topic, Teacher teacher) {
        this.lessonId = lessonId;
        this.type = type;
        this.topic = topic;
        this.teacher = teacher;
    }

    public String getLessonId() { return lessonId; }
    public LessonType getType() { return type; }
    public String getTopic() { return topic; }
    public Teacher getTeacher() { return teacher; }

    @Override
    public String toString() {
        return type + ": " + topic;
    }
}
