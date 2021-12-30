package com.itechart.students_lab.waybill_suppliers.controller;

import com.itechart.students_lab.waybill_suppliers.entity.ApplicationStatus;
import com.itechart.students_lab.waybill_suppliers.entity.dto.ApplicationDto;
import com.itechart.students_lab.waybill_suppliers.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping("/customer/{customerId}/applications")
    @PreAuthorize("hasAuthority('applications.all:read')")
    List<ApplicationDto> findAllApplications(@PathVariable Long customerId,
                                             @RequestParam(required = false, defaultValue = "0") int page,
                                             @RequestParam(required = false, defaultValue = "10") int count) {
        return applicationService.findAllApplications(customerId, page, count);
    }

    @GetMapping("/customer/{customerId}/application/{applicationNumber}")
    @PreAuthorize("hasAuthority('applications.all:read')")
    ApplicationDto findApplication(@PathVariable Long customerId,
                                   @PathVariable int applicationNumber) {
        return applicationService.findApplication(applicationNumber, customerId);
    }

    @GetMapping("/customer/{customerId}/applications/{status}")
    @PreAuthorize("hasAuthority('applications.all:read')")
    List<ApplicationDto> findApplicationsByStatus(@PathVariable Long customerId,
                                                  @PathVariable ApplicationStatus status,
                                                  @RequestParam(required = false, defaultValue = "0") int page,
                                                  @RequestParam(required = false, defaultValue = "10") int count) {
        return applicationService.findApplicationsByStatus(customerId, status, page, count);
    }

    @GetMapping("/customer/{customerId}/applications/outgoing")
    @PreAuthorize("hasAuthority('applications.dispatching:read')")
    List<ApplicationDto> findAllOutgoingApplications(@PathVariable Long customerId,
                                                     @RequestParam(required = false, defaultValue = "0") int page,
                                                     @RequestParam(required = false, defaultValue = "10") int count) {
        return applicationService.findAllOutgoingApplications(customerId, page, count);
    }

    @GetMapping("/customer/{customerId}/applications/outgoing/{status}")
    @PreAuthorize("hasAuthority('applications.dispatching:read')")
    List<ApplicationDto> findOutgoingApplicationsByStatus(@PathVariable Long customerId,
                                                          @PathVariable ApplicationStatus status,
                                                          @RequestParam(required = false, defaultValue = "0") int page,
                                                          @RequestParam(required = false, defaultValue = "10") int count) {
        return applicationService.findOutgoingApplicationsByStatus(customerId, status, page, count);
    }

    @PostMapping("/customer/{customerId}/application")
    @PreAuthorize("hasAuthority('applications.all:write')")
    ApplicationDto createNewApplication(@PathVariable Long customerId,
                                        @RequestBody ApplicationDto applicationDto) {
        return applicationService.createNewApplication(customerId, applicationDto);
    }

    @PutMapping("/customer/{customerId}/application/{applicationNumber}")
    @PreAuthorize("hasAnyAuthority('applications.dispatching:write', 'applications.all:write')")
    ApplicationDto changeApplicationStatus(@PathVariable Long customerId,
                                           @PathVariable int applicationNumber,
                                           @RequestParam ApplicationStatus status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return applicationService.changeApplicationStatus(currentUserName, customerId, applicationNumber, status);
    }

    @PutMapping("/customer/{customerId}/application/{applicationNumber}/placeItem/{applicationItemId}")
    @PreAuthorize("hasAuthority('applications.all:write')")
    ApplicationDto acceptApplicationItem(@PathVariable Long customerId,
                                         @PathVariable int applicationNumber,
                                         @PathVariable Long applicationItemId,
                                         @RequestParam int count) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return applicationService.acceptApplicationItems(currentUserName, customerId, applicationNumber, applicationItemId, count);
    }
}
