package com.example.CarSales.repository.jpa;

import com.example.CarSales.model.entity.jpa.CarJpa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  CarJpaMybatis extends JpaRepository<CarJpa,Long> {
    @Modifying
    @Query(value="update cars c set c.price=:price  where c.id =:id")
    void updateByPrice(Long price,Long id);
}
