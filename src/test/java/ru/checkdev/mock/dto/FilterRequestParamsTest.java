package ru.checkdev.mock.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FilterRequestParamsTest {

    @Test
    void whenObjectsHaveSameStateThenTheyAreEqual() {
        var left = new FilterRequestParams(List.of(1, 2), 3, 4, 5, 6, 7, true);
        var right = new FilterRequestParams(List.of(1, 2), 3, 4, 5, 6, 7, true);

        assertEquals(left, right);
        assertEquals(left.hashCode(), right.hashCode());
    }

    @Test
    void whenObjectsHaveDifferentStateThenTheyAreNotEqual() {
        var left = new FilterRequestParams(List.of(1, 2), 3, 4, 5, 6, 7, true);
        var right = new FilterRequestParams(List.of(1, 2), 3, 4, 5, 6, 7, false);

        assertNotEquals(left, right);
    }

    @Test
    void whenComparedWithAnotherTypeThenObjectsAreNotEqual() {
        var params = new FilterRequestParams(List.of(1), 2, 3, 4, 5, 6, true);

        assertNotEquals(params, "not a filter request params");
    }

    @Test
    void whenUsingNoArgsConstructorThenSettersPopulateFields() {
        var params = new FilterRequestParams();
        params.setTopicIds(List.of(1, 2));
        params.setSubmitterId(3);
        params.setWisherId(4);
        params.setAgreedWisherId(5);
        params.setStatus(6);
        params.setMode(7);
        params.setExclude(true);

        assertEquals(List.of(1, 2), params.getTopicIds());
        assertEquals(3, params.getSubmitterId());
        assertEquals(4, params.getWisherId());
        assertEquals(5, params.getAgreedWisherId());
        assertEquals(6, params.getStatus());
        assertEquals(7, params.getMode());
        assertEquals(true, params.isExclude());
    }
}
