package com.example.SpringBootDemo.Models.ColouredCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDataRepository extends JpaRepository<ColouredStageData, Long> {
}
