package com.DriverMileageTracker.Backend.Mappers;

import com.DriverMileageTracker.Backend.DTO.MonthlyReportDTO;
import com.DriverMileageTracker.Backend.Database.MonthlyReport;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-25T12:52:27+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class MonthlyReportMapperImpl implements MonthlyReportMapper {

    @Override
    public MonthlyReportDTO toDTO(MonthlyReport monthlyReport) {
        if ( monthlyReport == null ) {
            return null;
        }

        MonthlyReportDTO monthlyReportDTO = new MonthlyReportDTO();

        monthlyReportDTO.setId( monthlyReport.getId() );
        monthlyReportDTO.setMonth( monthlyReport.getMonth() );
        monthlyReportDTO.setTotalKm( monthlyReport.getTotalKm() );
        monthlyReportDTO.setReportFileUrl( monthlyReport.getReportFileUrl() );

        return monthlyReportDTO;
    }

    @Override
    public MonthlyReport toEntity(MonthlyReportDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MonthlyReport monthlyReport = new MonthlyReport();

        monthlyReport.setId( dto.getId() );
        monthlyReport.setMonth( dto.getMonth() );
        monthlyReport.setTotalKm( dto.getTotalKm() );
        monthlyReport.setReportFileUrl( dto.getReportFileUrl() );

        return monthlyReport;
    }
}
