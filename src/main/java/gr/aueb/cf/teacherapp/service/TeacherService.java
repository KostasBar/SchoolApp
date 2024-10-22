package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.core.EntityAlreadyExistsException;
import gr.aueb.cf.teacherapp.core.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherapp.mapper.Mapper;
import gr.aueb.cf.teacherapp.model.Teacher;
import gr.aueb.cf.teacherapp.model.static_data.Region;
import gr.aueb.cf.teacherapp.repository.RegionRepository;
import gr.aueb.cf.teacherapp.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //-->Creates constructor with required arguments
                         //---Needed for repositories and mapper
public class TeacherService implements ITeacherService {

    private final TeacherRepository teacherRepository;
    private final RegionRepository regionRepository;
    private final Mapper mapper;

    @Override
    @Transactional
    public Page<TeacherReadOnlyDTO> getPaginatedTeachers(int page, int size) {
        // Create a Pageable object with the requested page number and size
        Pageable pageable = PageRequest.of(page, size);

        // Fetch paginated list of teachers
        Page<Teacher> teacherPage = teacherRepository.findAll(pageable);

        // Map each Teacher entity to TeacherReadOnlyDTO
        return teacherPage.map(mapper::mapToTeacherReadOnlyDTO);
    }

    @Override
    @Transactional (rollbackOn = Exception.class) //In case of runtime exception this makes a rollback.
                                                  //No need of try catch and begin-commit transaction
    public Teacher saveTeacher(TeacherInsertDTO dto) throws EntityAlreadyExistsException, EntityInvalidArgumentException {
        if (teacherRepository.findByVat(dto.getVat()).isPresent()){
            throw new EntityAlreadyExistsException("Teacher", "Teacher with VAT " + dto.getVat() + " already exists!");
        }

        Teacher teacher = mapper.mapToTeacher(dto);
        Region region = regionRepository.findById(dto.getRegionId()).orElseThrow(
                ()-> new EntityInvalidArgumentException("Region", "Invalid Region Id!")
        );

        teacher.setRegion(region);

        return teacherRepository.save(teacher);
    }
}
