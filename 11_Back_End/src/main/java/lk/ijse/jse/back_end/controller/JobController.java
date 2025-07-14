package lk.ijse.jse.back_end.controller;

import lk.ijse.jse.back_end.dto.JobDTO;
import lk.ijse.jse.back_end.service.JobService;
import lombok.RequiredArgsConstructor;
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
public class JobController {

    private final JobService jobService;

    @PostMapping("create")
    public String createJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
        return "Job is running";
    }

    @GetMapping("getAllJobs")
    public List<JobDTO> getAllJob() {
        List<JobDTO> jobDTOList = jobService.getAllJob();
        return jobDTOList;
    }

    @PutMapping("update")
    public ResponseEntity<String> updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return new ResponseEntity<>("Job is updated", HttpStatus.OK);
    }

    @PatchMapping("status/{jobID}")
    private String changeJobStatus(@PathVariable("jobID") String jobId) {
        jobService.changeJobStatus(jobId);
        return "Job status changed";
    }

    @GetMapping("search/{keyword}")
    public List<JobDTO> searchJob(@PathVariable("keyword") String keyword) {
        return jobService.getAllJobsByKeyword(keyword);
    }
}
