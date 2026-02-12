package com.arhohuttunen.junit5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProductControllerWithoutNestedTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("POST returns HTTP status Bad Request when fields are missing")
    void postReturnsHttpStatusBadRequestWhenFieldsAreMissing() throws Exception {
        Product product = new Product(null, null, null);

        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST does not create a product when fields are missing")
    void postDoesNotCreateProductWhenFieldsAreMissing() throws Exception {
        Product product = new Product(null, null, null);

        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isBadRequest());

        verify(productRepository, never()).save(product);
    }

    @Test
    @DisplayName("POST returns HTTP status Created when fields are valid")
    void postReturnsHttpStatusCreatedWhenFieldsAreValid() throws Exception {
        Product product = new Product(1L, "Toothbrush", BigDecimal.valueOf(5.0));

        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("GET returns HTTP status Not Found when product is not found")
    void getReturnsHttpStatusNotFoundWhenProductIsNotFound() throws Exception {
        doThrow(new ProductNotFoundException()).when(productRepository).findById(1L);

        mockMvc.perform(get("/product/{productId}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET returns HTTP status OK when product is found")
    void getReturnsHttpStatusOkWhenProductIsFound() throws Exception {
        mockMvc.perform(get("/product/{productId}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET returns found product as JSON when product is found")
    void getReturnsFoundProductAsJsonWhenProductIsFound() throws Exception {
        Product product = new Product(1L, "Toothbrush", BigDecimal.valueOf(5.0));
        when(productRepository.findById(1L)).thenReturn(product);

        mockMvc.perform(get("/product/{productId}", 1L))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Toothbrush")))
                .andExpect(jsonPath("$.price", is(5.0)));
    }

    @Test
    @DisplayName("DELETE returns HTTP status Not Found when product is not found")
    void deleteReturnsHttpStatusNotFoundWhenProductIsNotFound() throws Exception {
        doThrow(new ProductNotFoundException()).when(productRepository).deleteById(1L);

        mockMvc.perform(delete("/product/{productId}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE returns HTTP status No Content when product is found")
    void deleteReturnsHttpStatusNoContentWhenProductIsFound() throws Exception {
        mockMvc.perform(delete("/product/{productId}", 1L))
                .andExpect(status().isNoContent());
    }
}
