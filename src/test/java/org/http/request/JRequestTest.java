package org.http.request;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class JRequestTest {

    @Test
    @DisplayName("main: Check if it throw exception.")
    void mainTest() {
        assertDoesNotThrow(() -> JRequest.main(null));
    }

}
