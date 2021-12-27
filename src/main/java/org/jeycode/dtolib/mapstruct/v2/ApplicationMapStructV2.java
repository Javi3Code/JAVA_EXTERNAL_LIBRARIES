package org.jeycode.dtolib.mapstruct.v2;

import static org.jeycode.helpers.LibGenericHelper.FAKER_INSTANCE;
import static org.jeycode.helpers.LibGenericHelper.GSON_CONVERTER;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jeycode.dtolib.converters.v2.ProgrammingTeacherMapper;
import org.jeycode.dtolib.entities.v2.ProgrammingTeacher;
import org.jeycode.dtolib.entities.v2.Student;
import org.jeycode.dtolib.entities.v2.XProgrammingLanguage;
import org.mapstruct.factory.Mappers;

public class ApplicationMapStructV2
{

      static ProgrammingTeacherMapper mapper = Mappers.getMapper(ProgrammingTeacherMapper.class);
      // @formatter:off
 
      public static void main(String[] args)
      { 
            
            var teachers = setOfTeachers(4);
            
            teachers.stream()
                  .map(teacher->{
                        var teacherDto =mapper.toTeacherDto(teacher);
                   return GSON_CONVERTER.toJson(teacherDto);     
                  })
                  .forEach(el-> System.out.printf("Dto--\n %s\n",el));
            
      }

      private static Set<ProgrammingTeacher> setOfTeachers(int size)
      {
                  return IntStream.range(0,size) 
                                    .mapToObj(num-> 
                                          ProgrammingTeacher.of()
                                                    .name(FAKER_INSTANCE.name().firstName())
                                                    .languages(setOfLanguages(3))
                                                    .students(setOfStudents(6))
                                               .create())
                                    .collect(Collectors.toUnmodifiableSet());
      }

      private static Set<Student> setOfStudents(int size)
      {
            return IntStream.range(0,size)
                           .mapToObj(num->
                                     Student.of()
                                         .name(FAKER_INSTANCE.name().fullName())
                                         .passed(FAKER_INSTANCE.bool().bool())
                                     .create())
                           .collect(Collectors.toUnmodifiableSet());
      }

      private static Set<XProgrammingLanguage> setOfLanguages(int size)
      {
            var programmingLanguage = FAKER_INSTANCE.programmingLanguage();
            return IntStream.range(0,size)
                                    .mapToObj(num-> 
                                             XProgrammingLanguage.of()
                                                 .name(programmingLanguage.name())
                                                 .yearsOfExperience(FAKER_INSTANCE.number().numberBetween(1,15))
                                                 .creator(programmingLanguage.creator())
                                             .create())
                                    .collect(Collectors.toUnmodifiableSet());
      }

}
