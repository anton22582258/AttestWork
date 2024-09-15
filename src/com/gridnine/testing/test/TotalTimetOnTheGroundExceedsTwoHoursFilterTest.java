package com.gridnine.testing.test;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.TotalTimetOnTheGroundExceedsTwoHoursFilter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalTimetOnTheGroundExceedsTwoHoursFilterTest {

    @Test
    public void testFilter() {
        // Создаем flightList для тестирования
        List<Flight> flightList = new ArrayList<>();

        // Добавляем рейсы со временем на земле менее 2 часов
        List<Segment> segments1 = new ArrayList<>();
        segments1.add(new Segment(LocalDateTime.of(2024, 4, 9, 10, 0),
                LocalDateTime.of(2024, 4, 9, 11, 0)));
        segments1.add(new Segment(LocalDateTime.of(2024, 4, 9, 12, 0),
                LocalDateTime.of(2024, 4, 9, 13, 0)));
        flightList.add(new Flight(segments1));

        // Добавляем рейсы со временем на земле более 2 часов
        List<Segment> segments2 = new ArrayList<>();
        segments2.add(new Segment(LocalDateTime.of(2024, 4, 9, 10, 0),
                LocalDateTime.of(2024, 4, 9, 11, 0)));
        segments2.add(new Segment(LocalDateTime.of(2024, 4, 9, 12, 0),
                LocalDateTime.of(2024, 4, 9, 15, 0)));
        flightList.add(new Flight(segments2));

        // Создаем экземпляр фильтра
        TotalTimetOnTheGroundExceedsTwoHoursFilter filter = new TotalTimetOnTheGroundExceedsTwoHoursFilter();

        // Применяем фильтр к flightList
        List<Flight> filteredFlights = filter.filter(flightList);
        System.out.println("Набор перелетов после фильтрации:");

        // Ожидаем, что будет исключен только рейс со временем на земле более 2 часов
        assertEquals(2, filteredFlights.size());
        assertEquals(flightList.get(0), filteredFlights.get(0));
        {
            System.out.println(filteredFlights);
        }
    }
}
