package com.school.main.service.assembler;

import com.school.main.domain.Teacher;
import com.school.main.service.dto.PromotionTeacherDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-07T18:22:39-0400",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public PromotionTeacherDto teacherToPromotionTeacherDto(Teacher entity) {
        if ( entity == null ) {
            return null;
        }

        PromotionTeacherDto promotionTeacherDto = new PromotionTeacherDto();

        promotionTeacherDto.setFirstName( entity.getFirstName() );

        return promotionTeacherDto;
    }
}
