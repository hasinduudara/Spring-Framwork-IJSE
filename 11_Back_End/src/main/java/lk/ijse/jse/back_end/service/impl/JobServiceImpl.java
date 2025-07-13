package lk.ijse.jse.back_end.service.impl;

import lk.ijse.jse.back_end.dto.JobDTO;
import lk.ijse.jse.back_end.entity.Job;
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
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

//    @Override
//    public void updateJob(JobDTO jobDTO) {
//        jobRepository.save(modelMapper.map(jobDTO, Job.class));
//    }

    @Override
    public void updateJob(JobDTO jobDTO) {
        Job job = jobRepository.findById(jobDTO.getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));
        // Map DTO to entity and save
        job.setJobTitle(jobDTO.getJobTitle());
        job.setCompany(jobDTO.getCompany());
        job.setLocation(jobDTO.getLocation());
        job.setType(jobDTO.getType());
        job.setActive(String.valueOf(jobDTO.isActive()));
        jobRepository.save(job);
    }

    @Override
    public List<JobDTO> getAllJob() {
        return jobRepository.findAll().stream()
                .map(job -> modelMapper.map(job, JobDTO.class))
                .toList();
    }

//    @Override
//    public void changeJobStatus(String jobId) {
//        jobRepository.updateJobStatus(jobId);
//    }

    @Override
    public void changeJobStatus(String jobId) {
        Job job = jobRepository.findById(Integer.parseInt(jobId))
                .orElseThrow(() -> new RuntimeException("Job not found"));
        job.setActive(String.valueOf(!Boolean.parseBoolean(job.isActive()))); // Toggle active status
        jobRepository.save(job);
    }


    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
        List<Job> allJobs =  jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());
    }


}
