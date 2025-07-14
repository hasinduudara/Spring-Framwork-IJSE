package lk.ijse.jse.back_end.service;

import lk.ijse.jse.back_end.dto.JobDTO;

import java.util.List;

public interface JobService {

    public void saveJob(JobDTO jobDTO);

    public void updateJob(JobDTO jobDTO);

    public List<JobDTO> getAllJob();

    void changeJobStatus(String jobId);

    List<JobDTO> getAllJobsByKeyword( String keyword);

    List<JobDTO> searchJob(String keyword);

}
