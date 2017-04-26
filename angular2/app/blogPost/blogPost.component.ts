import { Component, OnInit } from '@angular/core';

import { UserService } from '../_services/index';
import { Billet } from '../_models/index';
import { KeysPipe } from '../_models/index';

@Component({
    moduleId: module.id,
    templateUrl: 'blogPost.component.html'
})

export class BlogPostComponent implements OnInit {
    billets: Billet[];

        constructor(
        private userService: UserService) { }

        ngOnInit() {
        this.loadAllPost();
    }

        private loadAllPost() {
        this.userService.getBlogPost().subscribe(billets => { 
            
            this.billets = billets; 
            console.log(billets);
        });
        
    }
    
}