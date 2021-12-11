package com.itechart.students_lab.waybill_suppliers.mapper;

import com.itechart.students_lab.waybill_suppliers.entity.Car;
import com.itechart.students_lab.waybill_suppliers.entity.dto.CarDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CarMapper extends AddressMapper {
    CarDto carToCarDto(Car car);

    Car carDtoToCar(CarDto carDto);

    List<CarDto> carsListToCarDtoList(List<Car> cars);
}
