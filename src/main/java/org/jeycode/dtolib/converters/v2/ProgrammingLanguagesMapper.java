package org.jeycode.dtolib.converters.v2;

import org.jeycode.dtolib.dtos.v2.ProgrammingLanguageDto;
import org.jeycode.dtolib.entities.v2.XProgrammingLanguage;
import org.mapstruct.Mapper;

@Mapper
public interface ProgrammingLanguagesMapper
{

      XProgrammingLanguage toProgrammingLanguageEntity(ProgrammingLanguageDto dto);

      ProgrammingLanguageDto toProgrammingLanguageDto(XProgrammingLanguage entity);

}
