package com.mohannad.playerservice.controller;

import com.mohannad.playerservice.model.Player;
import com.mohannad.playerservice.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyString;
import static org.mockito.MockitoAnnotations.openMocks;

public class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @BeforeEach
    public void setup() {
        openMocks(this);
    }

    @Test
    public void whenGetAllPlayers_thenReturnResponseEntityWithPlayers() {

        Player player1 = new Player();
        Player player2 = new Player();
        when(playerService.getAllPlayers()).thenReturn(Arrays.asList(player1, player2));

        ResponseEntity<List<Player>> response = playerController.getAllPlayers();

        assertEquals(2, response.getBody().size());
    }

    @Test
    public void whenGetPlayerById_thenReturnResponseEntityWithPlayer() {
        Player player = new Player();
        player.setPlayerID("aardsda01");
        when(playerService.getPlayerById(anyString())).thenReturn(player);

        ResponseEntity<Player> response = playerController.getPlayerById(player.getPlayerID());

        assertEquals(player, response.getBody());
    }
}
