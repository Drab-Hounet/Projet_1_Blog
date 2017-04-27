import { Component, OnInit } from '@angular/core';

import { UserService } from '../_services/index';
import { Billet } from '../_models/index';
import { KeysPipe } from '../_helpers/pipe';

@Component({
    moduleId: module.id,
    templateUrl: 'blogPost.component.html'
})

export class BlogPostComponent implements OnInit {
    billets: Billet[];

    constructor( private userService: UserService) { }

    ngOnInit() {
        this.loadAllPost();
    }

    private loadAllPost() {
        this.userService.getBlogPost().subscribe(billets => {    
            console.log(billets);
            //This a solution to not make a pipe
            // const tab = Object.keys(billets).map(Key => billets[Key]);
            // console.log(tab);
            this.billets = billets;
        });
    }
    
}