package com.ayush.Commit_tracker.Repository;

import com.ayush.Commit_tracker.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {


}
