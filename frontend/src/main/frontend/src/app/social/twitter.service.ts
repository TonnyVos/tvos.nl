import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

import * as twitter from "twitter-text";

import { Tweet } from './tweet';

@Injectable()
export class TwitterService {

    private baseUrl: string = 'social/twitter/tonnyvos';
    
    constructor(private http: Http) {
    }

    getAll(): Observable<Tweet[]> {
        let result$ = this.http.get(this.baseUrl, { headers: this.getHeaders() }).map(mapTweets).catch(handleError);
        return result$;
    }
    
    private getHeaders() {
        let headers = new Headers();
        headers.append('Accept', 'application/json');
        return headers;
    }
}

function mapTweets(response: Response): Tweet[] {
    return response.json().slice(0, 3).map(toTweet);
}

function toTweet(r: any): Tweet {
    let tweet = <Tweet>({
        text: twitter.autoLink(r.text),
        datestring: (new Date(r.createdAt)).toDateString(),
        username: r.user.name,
        userpic: r.user.miniProfileImageURL,
        isretweet: r.retweet,
    });
    return tweet;
}

function handleError(error: any) {
    // log error
    let errorMsg = error.message || `Unable to retrieve tweets!`
    console.error(errorMsg);

    // throw an application level error
    return Observable.throw(errorMsg);
}
