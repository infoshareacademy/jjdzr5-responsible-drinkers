package com.infoshareacademy.drinkers.service.properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AppPropertiesTest {

    @Mock
    private Properties properties;
    @InjectMocks
    private AppProperties appProperties;

    @Test
    void getDatePattern_returnsEmptyProperty_dueToNullProperties() {
        // given
        AppProperties appProperties = new AppProperties((Properties) null);
        // when
        String actualDatePattern = appProperties.getDatePattern();
        // then
        assertTrue(actualDatePattern.isEmpty());
    }

    @Test
    void getDatePattern_returnsEmptyProperty_dueToEmptyValue() {
        // given
        String expectedDatePattern = "";
        given(properties.getProperty("dateFormat")).willReturn(expectedDatePattern);
        // when
        String actualDatePattern = appProperties.getDatePattern();
        // then
        assertSame(expectedDatePattern, actualDatePattern);
    }

    @Test
    void getDatePattern_returnsNonEmptyProperty() {
        // given
        String expectedDatePattern = "non empty";
        given(properties.getProperty("dateFormat")).willReturn(expectedDatePattern);
        // when
        String actualDatePattern = appProperties.getDatePattern();
        // then
        assertSame(expectedDatePattern, actualDatePattern);
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"non empty", "some other value"})
    void getDatePattern_returnsNonEmptyProperty(String expectedDatePattern) {
        // given
        given(properties.getProperty("dateFormat")).willReturn(expectedDatePattern);
        // when
        String actualDatePattern = appProperties.getDatePattern();
        // then
        assertSame(expectedDatePattern, actualDatePattern);
    }
}
