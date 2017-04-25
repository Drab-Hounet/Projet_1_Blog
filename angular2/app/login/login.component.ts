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
    data: string;

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

    let creds = JSON.stringify({ pseudo: pseudo.value, password: password.value });
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    this.http.post('http://localhost:8080/Projet_1_Blog/api/user', creds, {
      headers: headers
      })
      .subscribe(
        data => {
          this.saveJwt(data.json());
          pseudo = null;
          password = null;
        },
        err => this.logError(err.json().message),
        () => console.log('Authentication Complete')
      );
      console.log(this.data);
}
  logError(err:string) {
    console.error('There was an error: ' + err);
}
  saveJwt(jwt:string) {
    if(jwt) {
      localStorage.setItem('id_token', jwt)
    }
}
}
