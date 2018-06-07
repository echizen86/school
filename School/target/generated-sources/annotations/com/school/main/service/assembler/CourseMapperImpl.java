package com.school.main.service.assembler;

import com.school.main.domain.Course;
import com.school.main.service.dto.CourseDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-07T18:22:39-0400",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDto courseToCourseDTO(Course entity) {
        if ( entity == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( entity.getId() );
        courseDto.setName( entity.getName() );

        return courseDto;
    }
}
