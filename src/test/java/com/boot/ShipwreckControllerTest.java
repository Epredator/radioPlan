package com.boot;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import pl.etroya.radioplan.controller.ShipwreckController;
import pl.etroya.radioplan.model.Shipwreck;
import pl.etroya.radioplan.repository.ShipWreckRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {
    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipWreckRepository shipWreckRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet(){
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        when(shipWreckRepository.findOne(1L)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);
        verify(shipWreckRepository).findOne(1L);
        //assertEquals(1L, wreck.getId().longValue());
        assertThat(wreck.getId(), is(1L));

    }
}
