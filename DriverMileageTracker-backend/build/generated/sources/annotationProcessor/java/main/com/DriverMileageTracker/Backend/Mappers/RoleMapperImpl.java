package com.DriverMileageTracker.Backend.Mappers;

import com.DriverMileageTracker.Backend.DTO.RoleDTO;
import com.DriverMileageTracker.Backend.Database.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-23T09:55:55+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setRoleName( dto.getName() );
        role.setId( dto.getId() );

        return role;
    }

    @Override
    public RoleDTO toDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setName( role.getRoleName() );
        roleDTO.setId( role.getId() );

        return roleDTO;
    }
}
