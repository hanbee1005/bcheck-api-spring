package com.example.bcheckapi.controller;

import com.example.bcheckapi.dto.*;
import com.example.bcheckapi.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    final BookService bookService;

    @GetMapping
    public ResponseEntity<?> searchBooks(@RequestParam String word) {
        return ResponseEntity.ok(bookService.searchBookList(word));
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookRegisterRequest request) {
        return ResponseEntity.ok(bookService.registerBook(request));
    }

    @PatchMapping
    public ResponseEntity<?> changeBookOwner(@RequestBody BookOwnerChangeRequest request) {
        return ResponseEntity.ok(bookService.changeBookOwner(request));
    }

    @DeleteMapping
    public ResponseEntity<?> removeBook(@RequestBody BookRemoveRequest request) {
        return ResponseEntity.ok(bookService.removeBook(request));
    }

}
