package com.demo.study.springbootdemo;

import java.time.LocalDateTime;
import java.util.Collections;

import com.demo.study.springbootdemo.controller.BookController;
import com.demo.study.springbootdemo.domain.Book;
import com.demo.study.springbootdemo.service.BookService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/*
BookController.java 에서 책 리스트를 받아오는 테스트 
*/
@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    
    /*
    MockMvc : 컨트롤러 테스트 시 모든 의존성을 로드하는 것이 아는 BookController 관련 빈만 로드하여 가벼운 MVC테스트를 수행한다. 
    */
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    public void Book_MVC_테스트() throws Exception{
        Book book = new Book("Spring Boot Book",LocalDateTime.now());
        given(bookService.getBookList()).willReturn(Collections.singletonList(book)); // given()을 사용하여 getBookList() 메서드의 실행 반환값을 미리 정의 
        mvc.perform(get("/books"))
            .andExpect(status().isOk())                                 // HTTP 상태값이 200인지 테스트
            .andExpect(view().name("book"))                             // 반환되는 뷰의 이름이 "book" 인지 테스트
            .andExpect(model().attributeExists("bookList"))             // 모델의 프로퍼티 중 "bookList" 라는 프로퍼티가 존재하는지 테스트
            .andExpect(model().attribute("bookList", contains(book)));  // 모델의 프로퍼티 중 "bookList"라는 프로퍼티에 book 객체가 담겨져 있는지 테스트 
    }₩
}
