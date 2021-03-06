package com.project.results.mapper;

import com.project.results.domain.Commander;
import com.project.results.domain.CommanderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommanderMapper {

    @Autowired
    private ResultsMapper resultsMapper;

    @Autowired
    private CopMapper copMapper;

    public Commander mapToCommander(CommanderDto commanderDto) {
        return new Commander(
                commanderDto.getId(),
                commanderDto.getPosition(),
                commanderDto.getLogin(),
                commanderDto.getLastName(),
                commanderDto.getName(),
                commanderDto.getPluton_number()
        );
    }

    public CommanderDto mapToCommanderDto(Commander commander) {
        CommanderDto commanderDto = new CommanderDto(
                commander.getId(),
                commander.getPosition(),
                commander.getLogin(),
                commander.getName(),
                commander.getLastName(),
                commander.getPluton_number()
        );
        commanderDto.setCopDtoList(copMapper.mapCopDtoToList(commander.getCop()));
        return commanderDto;
    }

    public List<CommanderDto> mapCommanderDtoToList(final List<Commander> commanderList) {
        return commanderList.stream()
                .map(this::mapToCommanderDto)
                .collect(Collectors.toList());
    }
}
