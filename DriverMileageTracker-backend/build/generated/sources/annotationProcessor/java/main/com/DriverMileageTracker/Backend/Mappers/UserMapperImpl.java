package com.DriverMileageTracker.Backend.Mappers;

import com.DriverMileageTracker.Backend.DTO.RegisterDto;
import com.DriverMileageTracker.Backend.DTO.ReminderDTO;
import com.DriverMileageTracker.Backend.DTO.RoleDTO;
import com.DriverMileageTracker.Backend.DTO.UserDTO;
import com.DriverMileageTracker.Backend.Database.Reminder;
import com.DriverMileageTracker.Backend.Database.Role;
import com.DriverMileageTracker.Backend.Database.Users;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-25T12:52:28+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(Users user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setPhoneNumber( user.getPhoneNumber() );
        userDTO.setVehicleNumber( user.getVehicleNumber() );
        userDTO.setReminders( reminderListToReminderDTOList( user.getReminders() ) );
        userDTO.setRoles( roleSetToRoleDTOSet( user.getRoles() ) );
        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }

    @Override
    public Users toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( userDTO.getId() );
        users.setName( userDTO.getName() );
        users.setPhoneNumber( userDTO.getPhoneNumber() );
        users.setVehicleNumber( userDTO.getVehicleNumber() );
        users.setRoles( roleDTOSetToRoleSet( userDTO.getRoles() ) );
        users.setReminders( reminderDTOListToReminderList( userDTO.getReminders() ) );
        users.setPassword( userDTO.getPassword() );

        return users;
    }

    @Override
    public List<UserDTO> toDtoList(List<Users> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( Users users1 : users ) {
            list.add( toDto( users1 ) );
        }

        return list;
    }

    @Override
    public List<Users> toEntityList(List<UserDTO> userDTOs) {
        if ( userDTOs == null ) {
            return null;
        }

        List<Users> list = new ArrayList<Users>( userDTOs.size() );
        for ( UserDTO userDTO : userDTOs ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public Users registerDtoToEntity(RegisterDto dto) {
        if ( dto == null ) {
            return null;
        }

        Users users = new Users();

        users.setName( dto.getName() );
        users.setPhoneNumber( dto.getPhoneNumber() );
        users.setVehicleNumber( dto.getVehicleNumber() );
        users.setPassword( dto.getPassword() );

        return users;
    }

    @Override
    public RegisterDto entityToRegisterDto(Users user) {
        if ( user == null ) {
            return null;
        }

        RegisterDto registerDto = new RegisterDto();

        registerDto.setName( user.getName() );
        registerDto.setPassword( user.getPassword() );
        registerDto.setVehicleNumber( user.getVehicleNumber() );
        registerDto.setPhoneNumber( user.getPhoneNumber() );

        return registerDto;
    }

    protected ReminderDTO reminderToReminderDTO(Reminder reminder) {
        if ( reminder == null ) {
            return null;
        }

        ReminderDTO reminderDTO = new ReminderDTO();

        reminderDTO.setId( reminder.getId() );
        reminderDTO.setReminderText( reminder.getReminderText() );
        reminderDTO.setDueDate( reminder.getDueDate() );
        reminderDTO.setCompleted( reminder.isCompleted() );

        return reminderDTO;
    }

    protected List<ReminderDTO> reminderListToReminderDTOList(List<Reminder> list) {
        if ( list == null ) {
            return null;
        }

        List<ReminderDTO> list1 = new ArrayList<ReminderDTO>( list.size() );
        for ( Reminder reminder : list ) {
            list1.add( reminderToReminderDTO( reminder ) );
        }

        return list1;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setRoleName( role.getRoleName() );

        return roleDTO;
    }

    protected Set<RoleDTO> roleSetToRoleDTOSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDTO> set1 = new LinkedHashSet<RoleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleDTO( role ) );
        }

        return set1;
    }

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDTO.getId() );
        role.setRoleName( roleDTO.getRoleName() );

        return role;
    }

    protected Set<Role> roleDTOSetToRoleSet(Set<RoleDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new LinkedHashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleDTO roleDTO : set ) {
            set1.add( roleDTOToRole( roleDTO ) );
        }

        return set1;
    }

    protected Reminder reminderDTOToReminder(ReminderDTO reminderDTO) {
        if ( reminderDTO == null ) {
            return null;
        }

        Reminder reminder = new Reminder();

        reminder.setId( reminderDTO.getId() );
        reminder.setReminderText( reminderDTO.getReminderText() );
        reminder.setDueDate( reminderDTO.getDueDate() );
        reminder.setCompleted( reminderDTO.isCompleted() );

        return reminder;
    }

    protected List<Reminder> reminderDTOListToReminderList(List<ReminderDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Reminder> list1 = new ArrayList<Reminder>( list.size() );
        for ( ReminderDTO reminderDTO : list ) {
            list1.add( reminderDTOToReminder( reminderDTO ) );
        }

        return list1;
    }
}
