package com.arhohuttunen.junit5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductRepository productRepository;

    @Nested
    class Post {

        @Nested
        @DisplayName("when fields are missing")
        class WhenFieldsAreMissing {

            @Test
            @DisplayName("return HTTP status Bad Request")
            void returnHttpStatusBadRequest() throws Exception {
                Product product = new Product(null, null, null);

                mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("do not create a product")
            void doNotCreateProduct() throws Exception {
                Product product = new Product(null, null, null);

                mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                        .andExpect(status().isBadRequest());

                verify(productRepository, never()).save(product);
            }
        }

        @Nested
        @DisplayName("when fields are valid")
        class WhenFieldsAreValid {

            @Test
            @DisplayName("return HTTP status Created")
            void returnHttpStatusCreated() throws Exception {
                Product product = new Product(1L, "Toothbrush", BigDecimal.valueOf(5.0));

                mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                        .andExpect(status().isCreated());
            }
        }
    }

    @Nested
    class GetById {

        @Nested
        @DisplayName("when product is not found")
        class WhenProductIsNotFound {

            @Test
            @DisplayName("return HTTP status Not Found")
            void returnHttpStatusNotFound() throws Exception {
                doThrow(new ProductNotFoundException()).when(productRepository).findById(1L);

                mockMvc.perform(get("/product/{productId}", 1L))
                        .andExpect(status().isNotFound());
            }
        }

        @Nested
        @DisplayName("when product is found")
        class WhenProductIsFound {

            @Test
            @DisplayName("return HTTP status OK")
            void returnHttpStatusOk() throws Exception {
                mockMvc.perform(get("/product/{productId}", 1L))
                        .andExpect(status().isOk());
            }

            @Test
            void returnFoundProductAsJson() throws Exception {
                Product product = new Product(1L, "Toothbrush", BigDecimal.valueOf(5.0));
                when(productRepository.findById(1L)).thenReturn(product);

                mockMvc.perform(get("/product/{productId}", 1L))
                        .andExpect(jsonPath("$.id", is(1)))
                        .andExpect(jsonPath("$.name", is("Toothbrush")))
                        .andExpect(jsonPath("$.price", is(5.0)));
            }
        }
    }

    @Nested
    class Delete {

        @Nested
        @DisplayName("when product is not found")
        class WhenProductIsNotFound {

            @Test
            @DisplayName("return HTTP status Not Found")
            void returnHttpStatusNotFound() throws Exception {
                doThrow(new ProductNotFoundException()).when(productRepository).deleteById(1L);

                mockMvc.perform(delete("/product/{productId}", 1L))
                        .andExpect(status().isNotFound());
            }
        }

        @Nested
        @DisplayName("when product is found")
        class WhenProductIsFound {

            @Test
            @DisplayName("return HTTP status No Content")
            void returnHttpStatusNoContent() throws Exception {
                mockMvc.perform(delete("/product/{productId}", 1L))
                        .andExpect(status().isNoContent());
            }
        }
    }
}
