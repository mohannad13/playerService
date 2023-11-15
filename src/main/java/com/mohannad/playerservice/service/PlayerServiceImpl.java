package com.mohannad.playerservice.service;

import com.mohannad.playerservice.model.Player;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;


@Service
public class PlayerServiceImpl implements PlayerService {
    private final List<Player> players = new ArrayList<>();

    @Value("${player.mapping.fields}")
    private String fields;

    @PostConstruct
    public void loadPlayers() {
        try {
            if (fields == null || fields.trim().isEmpty()) {
                throw new IllegalStateException("player.mapping.fields property must be set");
            }
            Reader reader = new InputStreamReader(new ClassPathResource("player.csv").getInputStream(), StandardCharsets.UTF_8);
            // mapping strategy
            ColumnPositionMappingStrategy<Player> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Player.class);

            String[] memberFieldsToBindTo = fields.split(",");

            strategy.setColumnMapping(memberFieldsToBindTo);
            // Create CsvToBean and parse the CSV
            CsvToBean<Player> csvToBean = new CsvToBeanBuilder<Player>(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            players.addAll(csvToBean.parse());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(players);
    }

    @Override
    public Player getPlayerById(String playerId) {
        return players.stream()
                .filter(player -> player.getPlayerID().equals(playerId))
                .findFirst()
                .orElse(null);
    }

}
