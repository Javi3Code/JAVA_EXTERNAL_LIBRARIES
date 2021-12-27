package org.jeycode.dtolib.converters.v2;

import org.jeycode.dtolib.dtos.v2.ProgrammingTeacherDto;
import org.jeycode.dtolib.entities.v2.ProgrammingTeacher;
import org.mapstruct.Mapper;

@Mapper(uses = {StudentMapper.class,ProgrammingLanguagesMapper.class})
public interface ProgrammingTeacherMapper
{

      ProgrammingTeacher toTeacherEntity(ProgrammingTeacherDto dto);

      ProgrammingTeacherDto toTeacherDto(ProgrammingTeacher entity);
}
