package com.ayush.Commit_tracker.Repository;

import com.ayush.Commit_tracker.Model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitRepository extends JpaRepository<Commit,Long> {
}
