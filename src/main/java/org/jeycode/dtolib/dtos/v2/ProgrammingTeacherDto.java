package org.jeycode.dtolib.dtos.v2;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammingTeacherDto
{

      private String name;
      private Set<ProgrammingLanguageDto> languages;
      private Set<StudentDto> students;
}
