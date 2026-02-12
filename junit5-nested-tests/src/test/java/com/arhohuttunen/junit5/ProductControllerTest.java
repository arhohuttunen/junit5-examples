package com.arhohuttunen.junit5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.arhohuttunen.junit5.ProductBuilder.aProduct;
import static com.arhohuttunen.junit5.ProductBuilder.anInvalidProduct;
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

    @MockitoBean
    private ProductRepository productRepository;

    @Nested
    @DisplayName("Creating a product")
    class Post {

        @Nested
        @DisplayName("when fields are missing")
        class WhenFieldsAreMissing {

            @Test
            @DisplayName("return HTTP status Bad Request")
            void returnHttpStatusBadRequest() throws Exception {
                Product invalidProduct = anInvalidProduct().build();

                mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidProduct)))
                        .andExpect(status().isBadRequest());
            }

            @Test
            @DisplayName("do not create a product")
            void doNotCreateProduct() throws Exception {
                Product invalidProduct = anInvalidProduct().build();

                mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidProduct)));

                verify(productRepository, never()).save(invalidProduct);
            }
        }

        @Nested
        @DisplayName("when fields are valid")
        class WhenFieldsAreValid {

            @Test
            @DisplayName("return HTTP status Created")
            void returnHttpStatusCreated() throws Exception {
                Product product = aProduct().withId(1L).withName("Toothbrush").withPrice(5.0).build();

                mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                        .andExpect(status().isCreated());
            }
        }
    }

    @Nested
    @DisplayName("Finding a product")
    class GetById {

        @Nested
        @DisplayName("when product is not found")
        class WhenProductIsNotFound {

            @Test
            @DisplayName("return HTTP status Not Found")
            void returnHttpStatusNotFound() throws Exception {
                missingProduct(1L);

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
                havingPersisted(aProduct().withId(1L));

                mockMvc.perform(get("/product/{productId}", 1L))
                        .andExpect(status().isOk());
            }

            @Test
            @DisplayName("return found product as JSON")
            void returnFoundProductAsJson() throws Exception {
                havingPersisted(aProduct().withId(1L).withName("Toothbrush").withPrice(5.0));

                mockMvc.perform(get("/product/{productId}", 1L))
                        .andExpect(jsonPath("$.id", is(1)))
                        .andExpect(jsonPath("$.name", is("Toothbrush")))
                        .andExpect(jsonPath("$.price", is(5.0)));
            }
        }
    }

    @Nested
    @DisplayName("Deleting a product")
    class Delete {

        @Nested
        @DisplayName("when product is not found")
        class WhenProductIsNotFound {

            @Test
            @DisplayName("return HTTP status Not Found")
            void returnHttpStatusNotFound() throws Exception {
                missingProductToDelete(1L);

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

    void havingPersisted(ProductBuilder builder) {
        Product product = builder.build();
        when(productRepository.findById(product.getId())).thenReturn(product);
    }

    void missingProduct(Long id) {
        doThrow(new ProductNotFoundException()).when(productRepository).findById(id);
    }

    void missingProductToDelete(Long id) {
        doThrow(new ProductNotFoundException()).when(productRepository).deleteById(id);
    }
}
