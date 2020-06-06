package com.project.results.mapper;


import com.project.results.domain.Results;
import com.project.results.domain.ResultsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultsMapper {

    public Results mapToResults(final ResultsDto resultsDto) {
        return new Results(
                resultsDto.getId(),
                resultsDto.getCop_id(),
                resultsDto.getDate(),
                resultsDto.getTime(),
                resultsDto.getType_of_patrol(),
                resultsDto.getLegitimated(),
                resultsDto.getChecked_in_the_system(),
                resultsDto.getQuotations(),
                resultsDto.getInterventions(),
                resultsDto.getNoticions(),
                resultsDto.getMandates(),
                resultsDto.getVehicle_controls(),
                resultsDto.getArrested(),
                resultsDto.getKilometers_traveled()
        );
    }

    public Results mapToResultsDto(final Results results) {
        return new Results(
                results.getId(),
                results.getCop_id(),
                results.getDate(),
                results.getTime(),
                results.getType_of_patrol(),
                results.getLegitimated(),
                results.getChecked_in_the_system(),
                results.getQuotations(),
                results.getInterventions(),
                results.getNoticions(),
                results.getMandates(),
                results.getVehicle_controls(),
                results.getArrested(),
                results.getKilometers_traveled()
        );
    }

    public List<ResultsDto> mapResultsDtoList(final List<Results> resultsList) {
        return resultsList.stream()
                .map(r -> new ResultsDto(r.getId(),
                        r.getCop_id(),
                        r.getDate(),
                        r.getTime(),
                        r.getType_of_patrol(),
                        r.getLegitimated(),
                        r.getChecked_in_the_system(),
                        r.getQuotations(),
                        r.getInterventions(),
                        r.getNoticions(),
                        r.getMandates(),
                        r.getVehicle_controls(),
                        r.getArrested(),
                        r.getKilometers_traveled()))
                .collect(Collectors.toList());

    }
}
