package lk.ijse.jse.back_end.service;

import lk.ijse.jse.back_end.dto.JobDTO;
import lk.ijse.jse.back_end.entity.Job;
import lk.ijse.jse.back_end.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class JobService {

    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    public void saveJob(JobDTO jobDTO) {

        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }
}
