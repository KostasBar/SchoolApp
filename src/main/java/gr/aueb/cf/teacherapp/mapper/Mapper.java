package gr.aueb.cf.teacherapp.mapper;

import gr.aueb.cf.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherapp.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Teacher mapToTeacher(TeacherInsertDTO insertDTO){
        Teacher teacher = new Teacher();
        teacher.setFirstname(insertDTO.getFirstname());
        teacher.setLastname(insertDTO.getLastname());
        teacher.setVat(insertDTO.getVat());
        return teacher;
    }

    public TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(Teacher teacher){
        return new TeacherReadOnlyDTO(teacher.getId(), teacher.getCreatedAt(), teacher.getUpdatedAt(),
                teacher.getUuid(), teacher.getVat(), teacher.getFirstname(),
                teacher.getLastname(), teacher.getRegion().getName());

    }
}
