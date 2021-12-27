package org.jeycode.dtolib.converters.v2;

import org.jeycode.dtolib.dtos.v2.StudentDto;
import org.jeycode.dtolib.entities.v2.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper
{

      Student toStudentEntity(StudentDto dto);

      StudentDto toStudentDto(Student entity);

}
