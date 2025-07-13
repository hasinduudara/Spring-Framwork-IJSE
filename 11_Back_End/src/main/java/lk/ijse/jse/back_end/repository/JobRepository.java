package lk.ijse.jse.back_end.repository;

import jakarta.transaction.Transactional;
import lk.ijse.jse.back_end.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Job SET status ='Deactivated' WHERE id =?1", nativeQuery = true)
    void updateJobStatus(String jobId, String active);

    List<Job> findJobByJobTitleContainingIgnoreCase(String keyword);
}
