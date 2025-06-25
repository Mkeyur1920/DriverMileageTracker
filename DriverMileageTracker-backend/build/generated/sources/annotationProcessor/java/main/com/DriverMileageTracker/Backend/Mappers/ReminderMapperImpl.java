package com.DriverMileageTracker.Backend.Mappers;

import com.DriverMileageTracker.Backend.DTO.ReminderDTO;
import com.DriverMileageTracker.Backend.Database.Reminder;
import com.DriverMileageTracker.Backend.Database.Users;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-25T12:52:28+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class ReminderMapperImpl implements ReminderMapper {

    @Override
    public ReminderDTO toDto(Reminder reminder) {
        if ( reminder == null ) {
            return null;
        }

        ReminderDTO reminderDTO = new ReminderDTO();

        reminderDTO.setUserId( reminderUserId( reminder ) );
        reminderDTO.setId( reminder.getId() );
        reminderDTO.setReminderText( reminder.getReminderText() );
        reminderDTO.setDueDate( reminder.getDueDate() );
        reminderDTO.setCompleted( reminder.isCompleted() );

        return reminderDTO;
    }

    @Override
    public Reminder toEntity(ReminderDTO reminderDTO) {
        if ( reminderDTO == null ) {
            return null;
        }

        Reminder reminder = new Reminder();

        reminder.setUser( reminderDTOToUsers( reminderDTO ) );
        reminder.setId( reminderDTO.getId() );
        reminder.setReminderText( reminderDTO.getReminderText() );
        reminder.setDueDate( reminderDTO.getDueDate() );
        reminder.setCompleted( reminderDTO.isCompleted() );

        return reminder;
    }

    private Long reminderUserId(Reminder reminder) {
        if ( reminder == null ) {
            return null;
        }
        Users user = reminder.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Users reminderDTOToUsers(ReminderDTO reminderDTO) {
        if ( reminderDTO == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( reminderDTO.getUserId() );

        return users;
    }
}
