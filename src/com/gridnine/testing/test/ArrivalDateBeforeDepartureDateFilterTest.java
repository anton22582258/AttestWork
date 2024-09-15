package com.gridnine.testing.test;

import com.gridnine.testing.ArrivalDateBeforeDepartureDateFilter;
import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrivalDateBeforeDepartureDateFilterTest {

    @Test
    public void testFilter() {
        // Создаем flightList для тестирования
        List<Flight> flightList = new ArrayList<>();
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(LocalDateTime.of(2024, 4, 9, 10, 0),
                LocalDateTime.of(2024, 4, 9, 12, 0)));
        Flight flight1 = new Flight(segments);
        flightList.add(flight1);

        // Создаем экземпляр фильтра
        ArrivalDateBeforeDepartureDateFilter filter = new ArrivalDateBeforeDepartureDateFilter();

        // Применяем фильтр к flightList
        List<Flight> filteredFlights = filter.filter(flightList);
        System.out.println("Набор перелетов после фильтрации:");

        // Проверяем, что список остается неизменным, так как в данном случае прилет не раньше вылета
        assertEquals(flightList, filteredFlights);

        for (Flight flight : filteredFlights) {
            System.out.println(flight);
        }
    }
}