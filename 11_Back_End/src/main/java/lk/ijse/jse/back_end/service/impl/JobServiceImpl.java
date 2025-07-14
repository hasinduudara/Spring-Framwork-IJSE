package lk.ijse.jse.back_end.service.impl;

import lk.ijse.jse.back_end.dto.JobDTO;
import lk.ijse.jse.back_end.entity.Job;
import lk.ijse.jse.back_end.exceptions.ResourceNotFound;
import lk.ijse.jse.back_end.repository.JobRepository;
import lk.ijse.jse.back_end.service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveJob(JobDTO jobDTO) {
        if (jobDTO == null) {
            throw new IllegalArgumentException("Job ID cannot be null for creation");
        }
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    @Override
    public void updateJob(JobDTO jobDTO) {
        if (jobDTO == null || jobDTO.getId() == null) {
            throw new IllegalArgumentException("Job ID cannot be null for update");
        }
        Job excitingJob = jobRepository.findById(jobDTO.getId())
                .orElseThrow(() -> new ResourceNotFound("Job not found with ID: " + jobDTO.getId()));

//        Job job = jobRepository.findById(jobDTO.getId())
//                .orElseThrow(() -> new RuntimeException("Job not found"));

        excitingJob.setJobTitle(jobDTO.getJobTitle());
        excitingJob.setCompany(jobDTO.getCompany());
        excitingJob.setLocation(jobDTO.getLocation());
        excitingJob.setType(jobDTO.getType());
        excitingJob.setActive(String.valueOf(jobDTO.isActive()));
        jobRepository.save(excitingJob);
    }

    @Override
    public List<JobDTO> getAllJob() {
        List<Job> allJobs = jobRepository.findAll();
        return allJobs.stream()
                .map(job -> modelMapper.map(job, JobDTO.class))
                .toList();
    }

    @Override
    public void changeJobStatus(String jobId) {
        Job job = jobRepository.findById(Integer.parseInt(jobId))
                .orElseThrow(() -> new RuntimeException("Job not found"));
        job.setActive(String.valueOf(!Boolean.parseBoolean(job.isActive()))); // Toggle active status
        jobRepository.save(job);
    }


    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword cannot be null or empty");
        }
        List<Job> allJobs =  jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
        if (allJobs.isEmpty()) {
            throw new ResourceNotFound("No jobs found with keyword: " + keyword);
        }
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());
    }

    @Override
    public List<JobDTO> searchJob(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllJob();
        }
        List<Job> jobs = jobRepository.findJobByJobTitleContainingIgnoreCase(keyword.trim());
        return jobs.stream()
                .map(job -> modelMapper.map(job, JobDTO.class))
                .toList();
    }

}
