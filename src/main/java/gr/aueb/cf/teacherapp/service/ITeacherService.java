package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.core.EntityAlreadyExistsException;
import gr.aueb.cf.teacherapp.core.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherapp.model.Teacher;

public interface ITeacherService {
    Teacher saveTeacher(TeacherInsertDTO dto) throws EntityAlreadyExistsException, EntityInvalidArgumentException;
}
