import { Component, OnInit } from '@angular/core';
import { Tweet } from './tweet';
import { TwitterService } from "./twitter.service";

@Component({
    selector: 'div[myTwitter]',
    templateUrl: './twitter.component.html',
    styleUrls: ['./twitter.component.css']
})
export class TwitterComponent implements OnInit {
  tweets: Tweet[] = [];
  errorMessage: string = '';
  isLoading: boolean = true;

  constructor(private twitterService: TwitterService) { }

  ngOnInit(){
    this.twitterService
      .getAll()
      .subscribe(   
          t => this.tweets = t,
          e => this.errorMessage = e,
          () => this.isLoading = false);
  }

}