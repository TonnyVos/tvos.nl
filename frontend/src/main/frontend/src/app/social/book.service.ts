import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

import { Book } from './book';

@Injectable()
export class BookService {

    private baseUrl: string = 'social/goodreads';
    
    constructor(private http: Http) {
    }

    getAll(): Observable<Book[]> {
        let result$ = this.http.get(this.baseUrl, { headers: this.getHeaders() }).map(mapBooks).catch(handleError);
        return result$;
    }
    
    private getHeaders() {
        let headers = new Headers();
        headers.append('Accept', 'application/json');
        return headers;
    }
}

function mapBooks(response: Response): Book[] {
    return response.json().slice(0, 3).map(toBook);
}

function toBook(b: any): Book {
    let book = <Book>({
        title: b.book.title,
        isbn: b.book.isbn,
        isbn13: b.book.isbn13,
        author: b.book.authors[0].name,
        rating: b.rating,
        dateUpdated: b.dateUpdated,
    });
    return book;
}

function handleError(error: any) {
    // log error
    let errorMsg = error.message || `Unable to retrieve books!`
    console.error(errorMsg);

    // throw an application level error
    return Observable.throw(errorMsg);
}
