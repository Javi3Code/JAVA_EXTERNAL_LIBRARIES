package org.jeycode.dtolib.entities.v2;

import static org.jeycode.helpers.LibGenericHelper.UID_GENERATOR;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "of", buildMethodName = "create")
public class ProgrammingTeacher
{

      private final long id = UID_GENERATOR.nextLong();
      private String name;
      private Set<XProgrammingLanguage> languages;
      private Set<Student> students;
}
