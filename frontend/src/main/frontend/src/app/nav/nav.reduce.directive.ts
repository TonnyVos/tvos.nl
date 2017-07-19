import { Directive, ElementRef, Input, Inject, HostListener, OnInit } from '@angular/core';
import { DOCUMENT } from '@angular/platform-browser';

@Directive({ selector: '[myNavReducer]' })
export class NavReducerDirective  implements OnInit {
        
    private myNavBar = null;
    
    constructor(el: ElementRef, @Inject(DOCUMENT) private document: Document) {
       this.myNavBar = el;
    }
    
    ngOnInit() {}
    
    @HostListener("window:scroll", [])
    onWindowScroll() {
        if (this.document.body.scrollTop > 50) {
            this.myNavBar.nativeElement.parentNode.style.padding = '0px';
        } else if (this.document.body.scrollTop < 20) {
            this.myNavBar.nativeElement.parentNode.style.padding = '15px';
        }
    }
}