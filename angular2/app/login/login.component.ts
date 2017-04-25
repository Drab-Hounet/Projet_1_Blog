import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import { AlertService } from '../_services/index';
import { UserService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    returnUrl: string;
    pseudo: string;
    password: string;


    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private userService: UserService,
        private http: Http) { }

    ngOnInit() {
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    authenticate(pseudo, password) {

    let data = JSON.stringify({ pseudo: pseudo.value, password: password.value });
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Access-Control-Allow-Methods', 'POST');
    headers.append('Access-Control-Allow-Origin', '*');
    let options = new RequestOptions({ headers: headers, withCredentials: true });
    console.log(data);
   this.http.post('http://localhost:8080/Projet_1_Blog/api/user', data , options).map(res => res.json())
    .subscribe(response => {
        console.log(response);
    });
    }
}
