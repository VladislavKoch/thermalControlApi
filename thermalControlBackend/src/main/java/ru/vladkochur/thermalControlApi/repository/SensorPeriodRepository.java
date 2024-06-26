package ru.vladkochur.thermalControlApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.vladkochur.thermalControlApi.constants.Weekday;
import ru.vladkochur.thermalControlApi.entity.SensorPeriod;

import java.util.List;
import java.util.Optional;

public interface SensorPeriodRepository extends JpaRepository<SensorPeriod, Integer> {

    @Query("from SensorPeriod order by weekday")
     List<SensorPeriod> findAllOrderByWeekday();

     List<SensorPeriod> findAllByIsDefaultFalseOrderByWeekday();

     void deleteAllByIsDefaultFalse();

     Optional<SensorPeriod> findByWeekdayAndIsDefault(Weekday weekday, boolean isDefault);
}
