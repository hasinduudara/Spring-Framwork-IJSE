package lk.ijse.jse.back_end.controller;

import jakarta.validation.Valid;
import lk.ijse.jse.back_end.dto.JobDTO;
import lk.ijse.jse.back_end.service.JobService;
import lk.ijse.jse.back_end.util.APIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;


@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class JobController {

    private final JobService jobService;
    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @PostMapping("create")
    public ResponseEntity<APIResponse<List<JobDTO>>> createJob(@RequestBody @Valid JobDTO jobDTO) {

        log.info("Job creation successful");
        log.debug("Job creation request received with details: {}", jobDTO);
        log.error("Job creation fail");
        log.trace("Job creation trace");
        log.warn("Job creation warning");


        jobService.saveJob(jobDTO);
        return new ResponseEntity (new APIResponse<>(201,
                        "Job created successfully",
                        null
        ), HttpStatus.CREATED);
    }

    @GetMapping("getAllJobs")
    public ResponseEntity<APIResponse<List<JobDTO>>>getAllJob() {
        List<JobDTO> jobDTOList = jobService.getAllJob();
        return ResponseEntity.ok(new APIResponse<>(200,
                "All jobs fetched successfully",
                jobDTOList));
    }

    @PutMapping("update")
    public ResponseEntity<APIResponse<List<JobDTO>>> updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return ResponseEntity.ok(new APIResponse<>(200,
                "Job updated successfully",
                null));
    }

    @PatchMapping("status/{jobID}")
    private ResponseEntity<APIResponse<List<JobDTO>>> changeJobStatus(@PathVariable("jobID") String jobId) {
        jobService.changeJobStatus(jobId);
        return ResponseEntity.ok(new APIResponse<>(200,
                "Job status changed successfully",
                null));

    }

    @GetMapping("search/{keyword}")
    public ResponseEntity<APIResponse<List<JobDTO>>> searchJob(@PathVariable("keyword") String keyword) {
        return ResponseEntity.ok(new APIResponse<>(200,
                "Job List fetched successfully",
                jobService.searchJob(keyword)
        ));
    }
}
