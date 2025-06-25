package com.DriverMileageTracker.Backend.Mappers;

import com.DriverMileageTracker.Backend.DTO.MileageRecordDTO;
import com.DriverMileageTracker.Backend.DTO.ReminderDTO;
import com.DriverMileageTracker.Backend.DTO.RoleDTO;
import com.DriverMileageTracker.Backend.DTO.UserDTO;
import com.DriverMileageTracker.Backend.Database.MileageRecord;
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
public class MileageRecordMapperImpl implements MileageRecordMapper {

    @Override
    public MileageRecordDTO toDTO(MileageRecord mileageRecord) {
        if ( mileageRecord == null ) {
            return null;
        }

        MileageRecordDTO mileageRecordDTO = new MileageRecordDTO();

        mileageRecordDTO.setUserId( mileageRecordUserId( mileageRecord ) );
        mileageRecordDTO.setId( mileageRecord.getId() );
        mileageRecordDTO.setDate( mileageRecord.getDate() );
        mileageRecordDTO.setStartKm( mileageRecord.getStartKm() );
        mileageRecordDTO.setEndKm( mileageRecord.getEndKm() );
        mileageRecordDTO.setTotalKm( mileageRecord.getTotalKm() );
        mileageRecordDTO.setPhotoUrl( mileageRecord.getPhotoUrl() );
        mileageRecordDTO.setPlacesVisited( mileageRecord.getPlacesVisited() );
        mileageRecordDTO.setUser( usersToUserDTO( mileageRecord.getUser() ) );

        return mileageRecordDTO;
    }

    @Override
    public MileageRecord toEntity(MileageRecordDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MileageRecord mileageRecord = new MileageRecord();

        mileageRecord.setUser( mileageRecordDTOToUsers( dto ) );
        mileageRecord.setId( dto.getId() );
        mileageRecord.setDate( dto.getDate() );
        mileageRecord.setStartKm( dto.getStartKm() );
        mileageRecord.setEndKm( dto.getEndKm() );
        mileageRecord.setTotalKm( dto.getTotalKm() );
        mileageRecord.setPhotoUrl( dto.getPhotoUrl() );
        mileageRecord.setPlacesVisited( dto.getPlacesVisited() );

        return mileageRecord;
    }

    private Long mileageRecordUserId(MileageRecord mileageRecord) {
        if ( mileageRecord == null ) {
            return null;
        }
        Users user = mileageRecord.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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

    protected UserDTO usersToUserDTO(Users users) {
        if ( users == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( users.getId() );
        userDTO.setName( users.getName() );
        userDTO.setPhoneNumber( users.getPhoneNumber() );
        userDTO.setVehicleNumber( users.getVehicleNumber() );
        userDTO.setReminders( reminderListToReminderDTOList( users.getReminders() ) );
        userDTO.setRoles( roleSetToRoleDTOSet( users.getRoles() ) );
        userDTO.setPassword( users.getPassword() );

        return userDTO;
    }

    protected Users mileageRecordDTOToUsers(MileageRecordDTO mileageRecordDTO) {
        if ( mileageRecordDTO == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( mileageRecordDTO.getUserId() );

        return users;
    }
}
