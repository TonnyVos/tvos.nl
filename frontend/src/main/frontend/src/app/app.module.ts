import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { NavComponent } from './nav/nav.component';
import { TwitterComponent } from './social/twitter.component';
import { TwitterService } from './social/twitter.service';
import { BookComponent } from './social/book.component';
import { BookService } from './social/book.service';
import { NavReducerDirective } from './nav/nav.reduce.directive';

@NgModule({
  declarations: [
    NavComponent,
    NavReducerDirective,
    TwitterComponent,
    BookComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [TwitterService, BookService],
  bootstrap: [NavComponent, TwitterComponent, BookComponent]
})
export class AppModule { }