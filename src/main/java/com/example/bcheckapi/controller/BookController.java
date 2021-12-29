package com.example.bcheckapi.controller;

import com.example.bcheckapi.dto.BookRegisterRequest;
import com.example.bcheckapi.dto.BookSearchResponse;
import com.example.bcheckapi.dto.GeneralResponse;
import com.example.bcheckapi.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "[002] 도서 관리", description = "도서 조회, 추가, 수정, 삭제")
@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(description = "도서 조회 (도서명, ISBN 검색)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "검색된 도서 리스트를 반환한다.",
                    content = @Content(schema = @Schema(allOf = BookSearchResponse.class)))
    })
    @GetMapping
    public ResponseEntity<?> searchBooks(@Parameter(description = "도서명 or ISBN", example="토비") @RequestParam(required = false) String word) {
        return ResponseEntity.ok(bookService.searchBookList(word));
    }

    @Operation(description = "도서 등록")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "도서 추가 후 결과를 반환한다.",
                    content = @Content(schema = @Schema(implementation = GeneralResponse.class)))
    })
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookRegisterRequest request) {
        return ResponseEntity.ok(new GeneralResponse(200, "도서 등록 성공", bookService.addBook(request)));
    }

//    @Operation(description = "도서 소유자 수정")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "도서 소유자 수정 후 결과를 반환한다.",
//                    content = @Content(schema = @Schema(implementation = GeneralResponse.class)))
//    })
//    @PatchMapping
//    public ResponseEntity<?> changeBookOwner(@RequestBody BookOwnerChangeRequest request) {
//        return ResponseEntity.ok(bookService.changeBookOwner(request));
//    }
//
//    @Operation(description = "도서 삭제 (삭제 여부 수정)")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "도서 삭제 후 결과를 반환한다.",
//                    content = @Content(schema = @Schema(implementation = GeneralResponse.class)))
//    })
//    @DeleteMapping
//    public ResponseEntity<?> removeBook(@RequestBody BookRemoveRequest request) {
//        return ResponseEntity.ok(bookService.removeBook(request));
//    }

}
