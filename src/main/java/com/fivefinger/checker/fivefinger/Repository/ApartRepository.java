package com.fivefinger.checker.fivefinger.Repository;

import com.fivefinger.checker.fivefinger.Entity.Apart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartRepository extends JpaRepository<Apart, Long> {


}
