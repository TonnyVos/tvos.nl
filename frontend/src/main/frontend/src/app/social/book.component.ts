import { Component, OnInit } from '@angular/core';
import { Book } from './book';
import { BookService } from "./book.service";

@Component({
    selector: 'div[myBooks]',
    templateUrl: './book.component.html',
    styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  books: Book[] = [];
  errorMessage: string = '';
  isLoading: boolean = true;

  constructor(private bookService: BookService) { }

  ngOnInit(){
    this.bookService
      .getAll()
      .subscribe(   
          b => this.books = b,
          e => this.errorMessage = e,
          () => this.isLoading = false);
  }

}