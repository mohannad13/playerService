package com.mohannad.playerservice.service;

import com.mohannad.playerservice.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
        "player.mapping.fields=playerID,birthYear,birthMonth,birthDay,birthCountry,birthState,birthCity," +
                "deathYear,deathMonth,deathDay,deathCountry,deathState,deathCity," +
                "nameFirst,nameLast,nameGiven,weight,height,bats,throwsHand,debut,finalGame,retroID,bbrefID"
})
public class PlayerServiceTest {

    @Autowired
    private PlayerServiceImpl playerService;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void whenGetAllPlayers_thenReturnPlayerList() {
        List<Player> result = playerService.getAllPlayers();


        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    public void whenGetPlayerById_thenReturnPlayer() {
        String knownPlayerId = "aardsda01";

        Player result = playerService.getPlayerById(knownPlayerId);

        assertNotNull(result);
        assertEquals(knownPlayerId, result.getPlayerID());
    }
}
